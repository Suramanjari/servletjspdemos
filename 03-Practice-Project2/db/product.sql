USE mydb;

create table `product` (
	`name` varchar(255) null default null,
	`colour` varchar(255) null default null,
	`price` bigint(20) not null auto_increment,
	primary key (`price`)
);