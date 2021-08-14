## Raspberry Pi installation

Download **Raspberry Pi OS Lite** image and write/burn it to SD card   (in my case filename was _2021-05-07-raspios-buster-armhf-lite.img_)  
  
Start raspberry.  
Login with pi:raspberry  
Run commands:  
`sudo apt-get update`  
`sudo apt-get upgrade`  
`sudo raspi-config`  

Enable SSH access in **Interface options -> SSH**   
Change default password in **System -> password**  

Download **Bellsoft Liberica JRE 11** for embedded devices (ARM 32bit)  
in my case it was https://download.bell-sw.com/java/11.0.12+7/bellsoft-jre11.0.12+7-linux-arm32-vfp-hflt.deb  
install by running `sudo apt install ./bellsoft-jre11.0.12+7-linux-arm32-vfp-hflt.deb`  
