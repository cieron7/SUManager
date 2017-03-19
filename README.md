# SUManager
学生会管理系统 v1.0

###windows 本地host修改 
127.0.0.1 su.dqsy.net<br>
127.0.0.1 img.dqsy.net<br>
###nginx 配置
    worker_processes  1;
    events {
        worker_connections  1024;
    }
    http {
        include       mime.types;
        default_type  application/octet-stream;

        sendfile        on;
        keepalive_timeout  65;

        server {
		    listen       80;
            server_name  img.dqsy.net;

            location / {
                root   C:/uploadfile;
                index  index.html index.htm;
            }

            error_page   500 502 503 504  /50x.html;
            location = /50x.html {
                root   html;
            }
        }
    }
