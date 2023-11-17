# Tailscale Android SwiftSku Build

This is a fork of the Tailscale Android client, with following features:
- No Google Sign-In dependency
- No Welcome screen
- QR code login
- Authkey based login using intent
- Broadcasts when VPN state changes
- Broadcast receiver to start/stop VPN
- Broadcast receiver to start the app at boot
- Intent to change hostname


## Preparing a build environment

Depending on your development environment:

- Go runtime (https://go.dev/dl/)
- Android SDK (`sudo apt install android-sdk`)

### Install dependences
```sh
sudo make androidsdk
```

### Docker
```sh
sudo make dockershell
```

### Build
```sh
sudo make apk
or
sudo make tailscale-debug.apk
```

### Install
```sh
make install
or
adb install -r tailscale-debug.apk
```

### Uninstall
```sh
adb uninstall com.swiftsku.swiftscale
```

## Intents
### Run
```sh
adb shell am start -n com.swiftsku.swiftscale/com.swiftsku.swiftscale.IPNActivity
```

### Start VPN
```sh
adb shell am broadcast -a com.swiftsku.swiftscale.CONNECT_VPN -n com.swiftsku.swiftscale/.IPNReceiver
```

### Stop VPN
```sh
adb shell am broadcast -a com.swiftsku.swiftscale.DISCONNECT_VPN -n com.swiftsku.swiftscale/.IPNReceiver
```

### Start VPN with authkey
```sh
adb shell am broadcast -a com.swiftsku.swiftscale.AUTHKEY -n com.swiftsku.swiftscale/.IPNReceiver --es authkey "key"
```


### Hostname rename
```sh
adb shell am broadcast -a com.swiftsku.swiftscale.HOSTNAME -n com.swiftsku.swiftscale/.IPNReceiver --es hostname "new-name"
```

## Broadcasts
### VPN state
To receive VPN state changes, register a broadcast receiver for `com.swiftsku.swiftscale.VPN_STATUS` and key `status` in the intent extras.  
To trigger a status broadcast, send a broadcast with action `com.swiftsku.swiftscale.GET_VPN_STATUS`