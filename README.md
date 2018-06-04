# SUManager
学生会管理系统 v1.0

# V1.0 
实现整个部门的人员管理，部门管理。
通过该该系统可以发布最新资讯、最新活动
登录用户可以参与活动。评价活动。
### What's Next?

### 本地host修改
    127.0.0.1 su.desy.net
    127.0.0.1 img.desy.net

### nginx
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
        
        ...
