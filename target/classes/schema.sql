create table dog
(
   id varchar(255) not null,
   url varchar(255) not null,
   breed varchar(255) not null,
   votes bigint,
   weightlb int,
   color varchar(255),
   age int,
   personality  varchar(255),
   primary key(id)
);
create index breedIdx on dog (breed, votes desc);