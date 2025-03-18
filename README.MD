# Homechat
Homechat is a very simple chat application for your home.
It really doesn't have any features you would expect a chat system to have, but something works.
This is a toy project for me to get an application to run on docker/kubernetes.
Architecture:
- Static html/javascript web page served by nginx
- Java spring boot backend broadcasting messages to every other connected user via websockets

![example.jpg](other/example.jpg)

### Todo

- Create accounts
- Message persistence in containerised database + volume
- Add DNS to router
- Run on Kubernetes
- End-to-end encryption
- Send photos
- Online status heartbeats

### Bugs

- Message broadcast should be per user, not all users