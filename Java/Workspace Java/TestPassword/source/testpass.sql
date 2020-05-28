DROP DATABASE IF EXISTS testpass;
CREATE DATABASE testpass;
USE testpass;

CREATE TABLE `user`(
    `user` VARCHAR(30),
    pass VARCHAR(30)
);
INSERT `user` values ('root', 'root'),('root2', 'root2');

select * from `user`;