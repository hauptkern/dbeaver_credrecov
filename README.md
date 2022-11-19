# DBeaver Credentials Recovery Tool (JDK18)


## Downloads
 [DBeaver Credentials Recovery Tool v1.0](https://github.com/hauptkern/dbeaver_credrecov/releases/download/Release/dbeaver_credrecov-1.0.jar)

## How to find the credential files
 On Linux and Mac OS you can find credential files using this command:\
 `sudo find / -name credentials-config.json | grep "dbeaver"`\
 \
 On Windows\
 `C:\Users\{USERNAME}\AppData\Roaming\DBeaverData\workspace6\General\.dbeaver\credentials-config.json`
## Usage
 `java -jar dbeaver_credrecov-1.0.jar`
## Screenshots

![Image](https://github.com/hauptkern/dbeaver_credrecov/blob/main/screenshots/screenshot0.png)
