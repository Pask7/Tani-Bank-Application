/*Drop table if exists Customer;
Drop table if exists Account;*/

create table Customer
(
	
   customerId integer not null,
   name varchar(255) not null,
   surname varchar(255),
   birthDate timestamp,
   address varchar(255),
   accounts varchar(255),
   primary key(customerId)
);

create table Account
(
   id integer not null,
   customerId integer not null,
   displayName varchar(255),
   primary key(id)
 
);
