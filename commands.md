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
```adb uninstall com.tailscale.ipn```

## Intents
### Run
```adb shell am start -n com.tailscale.ipn/com.tailscale.ipn.IPNActivity```

### Start VPN
```adb shell am broadcast -a com.tailscale.ipn.CONNECT_VPN -n com.tailscale.ipn/.IPNReceiver```

### Stop VPN
```adb shell am broadcast -a com.tailscale.ipn.DISCONNECT_VPN -n com.tailscale.ipn/.IPNReceiver```

### Start VPN with authkey
```adb shell am broadcast -a com.tailscale.ipn.AUTHKEY -n com.tailscale.ipn/.IPNReceiver --es authkey "key"```


### Node rename
```adb shell am broadcast -a com.tailscale.ipn.HOSTNAME -n com.tailscale.ipn/.IPNReceiver --es hostname "new-name"```

