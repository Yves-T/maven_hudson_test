create table STOCK(
stock_id integer not null,
stock_code varchar(10),
stock_name varchar(20),
primary key (stock_id)
);
create table STOCK_DAILY_RECORD(
RECORD_ID integer not null,
PRICE_OPEN float (6),
PRICE_CLOSE float (6),
PRICE_CHANGE float(6),
VOLUME bigint,
ADATE date not null,
STOCK_ID integer,
primary key (RECORD_ID)
);
create table hibernate_unique_key(
next_hi integer
);
insert into hibernate_unique_key values 1;