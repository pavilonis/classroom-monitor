## Raspberry Pi installation

Download **Raspberry Pi OS Lite** image and write/burn it to SD card   (in my case filename was _2021-05-07-raspios-buster-armhf-lite.img_)  
  
Start raspberry.  
Login with pi:raspberry  
Run commands:  
`sudo apt-get update`  
`sudo apt-get upgrade`  

Install packages needed for displaying UI elements:  
`sudo apt install xorg`

`sudo raspi-config`  
Enable SSH access in **Interface Options -> SSH**   
Change default password in **System Options -> password**  

[Download **Bellsoft Liberica JRE 11 ARM32 FULL**](https://download.bell-sw.com/java/11.0.12+7/bellsoft-jre11.0.12+7-linux-arm32-vfp-hflt-full.deb)  
Install it by running `sudo apt install ./package-file-name.deb`  

create `/opt/classroom-monitor` directory and place there configuration file `app.properties` containing properties (change values):  
```
api.auth.username=admin  
api.auth.password=admin  
api.uri=http://localhost:8080  
api.levels=1  
api.building=SCHOOL  

api.test-mode=true
api.request.interval=30
screen.classrooms.limit=21
screen.header.text=Test Header Text
```

Build project JAR file by running maven `clean` and `package` commands.  
Copy created *.jar file from project's target directory into raspberry pi's /opt/classroom-monitor/  

Create systemd service:  
`sudo nano /lib/systemd/system/classroom-monitor.service`  

paste the following file contents:
```
[Unit]
Description=Classroom-monitor JavaFX application
After=multi-user.target

[Service]
WorkingDirectory=/opt/classroom-monitor
ExecStart=sudo java -Dglass.platform=Monocle -jar classroom-monitor-1.6.jar

[Install]
WantedBy=multi-user.target   
```

`sudo systemctl daemon-reload`  

Enable application automatic startup  
`sudo systemctl enable classroom-monitor.service`  

Save and restart application  
`sudo reboot now`  
