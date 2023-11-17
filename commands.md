<!-- note in quotes -->

Note: Use `sudo` in front make commands if it fails


### Install dependences
```sudo make androidsdk```

### Docker
```sudo make dockershell```

### Build
```sudo make apk```
```sudo make tailscale-debug.apk```

### Install
```make install```
```adb install -r tailscale-debug.apk```

### Uninstall
```adb uninstall com.swiftsku.swiftscale```

## Intents
### Run
```adb shell am start -n com.swiftsku.swiftscale/com.swiftsku.swiftscale.IPNActivity```

### Start VPN
```adb shell am broadcast -a com.swiftsku.swiftscale.CONNECT_VPN -n com.swiftsku.swiftscale/.IPNReceiver```

### Stop VPN
```adb shell am broadcast -a com.swiftsku.swiftscale.DISCONNECT_VPN -n com.swiftsku.swiftscale/.IPNReceiver```

### Start VPN with authkey
```adb shell am broadcast -a com.swiftsku.swiftscale.AUTHKEY -n com.swiftsku.swiftscale/.IPNReceiver --es authkey "key"```


### Node rename
```adb shell am broadcast -a com.swiftsku.swiftscale.HOSTNAME -n com.swiftsku.swiftscale/.IPNReceiver --es hostname "new-name"```

