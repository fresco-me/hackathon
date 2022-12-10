#!/bin/sh
sudo apt install docker.io -y 
sudo systemctl unmask docker
sudo service docker restart
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube_latest_amd64.deb
sudo dpkg -i minikube_latest_amd64.deb
rm -rf minikube_latest_amd64.deb