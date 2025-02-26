/*
 * Copyright 2021 Signal Messenger, LLC
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.whispersystems.textsecuregcm.tests.util;

import java.util.Random;

import org.signal.libsignal.protocol.ecc.Curve;
import org.whispersystems.textsecuregcm.storage.Device;
import org.whispersystems.textsecuregcm.util.Util;

public class DevicesHelper {

  private static final Random RANDOM = new Random();

  public static Device createDevice(final long deviceId) {
    return createDevice(deviceId, 0);
  }

  public static Device createDevice(final long deviceId, final long lastSeen) {
    return createDevice(deviceId, lastSeen, 0);
  }

  public static Device createDevice(final long deviceId, final long lastSeen, final int registrationId) {
    final Device device = new Device();
    device.setId(deviceId);
    device.setLastSeen(lastSeen);
    device.setUserAgent("OWT");
    device.setRegistrationId(registrationId);

    setEnabled(device, true);

    return device;
  }

  public static void setEnabled(Device device, boolean enabled) {
    if (enabled) {
      device.setSignedPreKey(KeysHelper.signedECPreKey(RANDOM.nextLong(), Curve.generateKeyPair()));
      device.setPhoneNumberIdentitySignedPreKey(KeysHelper.signedECPreKey(RANDOM.nextLong(), Curve.generateKeyPair()));
      device.setGcmId("testGcmId" + RANDOM.nextLong());
      device.setLastSeen(Util.todayInMillis());
    } else {
      device.setSignedPreKey(null);
    }

    // fail fast, to guard against a change to the isEnabled() implementation causing unexpected test behavior
    assert enabled == device.isEnabled();
  }

}
