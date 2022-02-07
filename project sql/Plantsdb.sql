---product_details----
create table product_details
(
plant_id number generated by default as identity(start with 1001 increment by 1), 
plant_name varchar(30)not null,
plant_description varchar(1000),
plant_price number(10),
category_name varchar2(20),
constraint pk_plaid primary key(plant_id)
);
desc product_details;
select *from product_details;
update product_details set picture='curryplant.jpg' where plant_id=1003;
update product_details set picture='bambooplant.jpg' where plant_id=1021;
update product_details set picture='hibiscuss.jpg' where plant_id=1022;
update product_details set picture='tulsi.jpg' where plant_id=1023;
update product_details set picture='moneyplant.jpg' where plant_id=1024;
update product_details set picture='lilyplant.jpg' where plant_id=1061;
update product_details set picture='bonsaiplant.jpg' where plant_id=1062;


--delete from product_details;
desc product_details;
commit;
--alter table product_details add status varchar2(50) default 'available';

insert into product_details (plant_name,plant_description,plant_price,category_name) values('curryplant','The leaves of this plant are used in most of the Indian curries and adds a special aroma to the dishes',200,'medicinal');
insert into product_details (plant_name,plant_description,plant_price,category_name) values('two layer bamboo','Two-layered lucky bamboo is an expression of love and is also said to double your luck',250,'bamboo');
insert into product_details (plant_name,plant_description,plant_price,category_name) values('red hibiscus plant','Hibiscus is a genus of flowering plants in the mallow family',100,'flowering plant');
insert into product_details (plant_name,plant_description,plant_price,category_name) values('thulsi plant',' helps in the healing of the human body',400,'medicinal');
insert into product_details (plant_name,plant_description,plant_price,category_name) values('green money plant','money plant is good for wealth',150,'money plant');
insert into product_details (plant_name,plant_description,plant_price,category_name) values('peace lily plant','People with green thumb love this beautiful plant because of its adaptive nature and low maintenance features',300,'indoor plant');
insert into product_details (plant_name,plant_description,plant_price,category_name) values('boxwood bonsai','Boxwood Bonsai plant can tolerate high sunlight and one of the useful plants, which can be grown in partial shade',350,'bonsai plant');


----user_details------
create table user_details(user_id number generated by default as identity(start with 1 increment by 1),
user_name varchar2(30),
email_id varchar2(30),
user_password varchar2(20),mobile_number number(10),
address varchar2(100),role_name varchar2(10) default 'user',
constraint pk_user_id primary key(user_id)
);

--alter table user_details add role_name varchar2(10) default 'user'; 
desc user_details;
select *from user_details;
insert into user_details(user_name,email_id,user_password,mobile_number,address,role_name)values('sangeetha','sangi412@gmail.com','sangi6123',8940157879,'madurai','admin');
--alter table user_details modify role varchar2(10) default 'user';
----drop  table user_details;
select * from user_details where user_role='admin' and Email_id='sangi412@gmail.com' and user_password='sangi6123';



update product_details set picture='https://imgcdn.floweraura.com/curry-plant-9978910pl-A.jpg.jpg?tr=w-264,q-70' where plant_id=1003;
update product_details set picture='https://imgcdn.floweraura.com/2-layer-bamboo-9889600pl-A.jpg?tr=w-264,q-70' where plant_id=1021;
update product_details set picture='https://imgcdn.floweraura.com/red-hibiscus-plant-9979100pl-A.jpg?tr=w-264,q-70' where plant_id=1022;
update product_details set picture='https://imgcdn.floweraura.com/sacred-tulsi-plant-9967820pl-A.jpg?tr=w-264,q-70'where plant_id=1023;
update product_details set picture='https://imgcdn.floweraura.com/lucky-money-plant-9903407pl-A.jpg?tr=w-264,q-70'where plant_id=1024;

-----order_details---

create table order_details(orders_id number generated by default as identity(start with 4001 increment by 1)primary key,
user_id number,plant_id number,quantity int ,totalprice number(10),address varchar2(200),order_date date default sysdate,constraint fk_userid foreign key(user_id)
references user_details(user_id),constraint fk_plantid foreign key(plant_id)
references product_details(plant_id));
--drop table order_details;
select * from order_details;
desc order_details;
commit;
update user_details set wallet=0 where role_name='admin';
--alter table user_details add wallet number default 50000; 
--alter table user_details add picture varchar2(3000);
select * from product_details where PLANT_NAME like 'dfghj%' or  CATEGORY_NAME like 'medicin%';

--cart----
create table cart(cart_id  number generated by default as identity(start with 5001 increment by 1)primary key,
user_id number,plant_id number,
constraint fk_user_id foreign key(user_id)
references user_details(user_id),constraint fk_plant_id foreign key(plant_id) references product_details(plant_id)); 
select * from cart; 
commit;


--order by---

select * from order_details  where user_id=2  order by order_date desc;

select plant_name,plant_description,plant_price,category_name from product_details where plant_id in(select plant_id from cart where user_id =2);

select  p.plant_name,p.PLANT_PRICE,sum(o.quantity) quantiy from product_details p join order_details o on p.plant_id=o.plant_id group by (p.plant_name,p.plant_price) order by sum(quantity) FETCH FIRST 1 ROWS ONLY;

select  p.plant_name,p.PLANT_PRICE,p.CATEGORY_NAME,p.plant_id,p.PLANT_DESCRIPTION ,sum(o.quantity) quantiy from product_details p join order_details o on p.plant_id=o.plant_id group by (p.plant_name,p.plant_price,p.CATEGORY_NAME,p.plant_id,p.PLANT_DESCRIPTION ) order by sum(quantity) FETCH FIRST 1 ROWS ONLY;;

desc product_details;
desc order_details;


select user_id,plant_id,quantity,totalprice,address,order_date,order_status from order_details  where order_status='not delivered' and  user_id='1' order by order_date desc;
select  ORDERS_ID,PLANT_ID,USER_ID,QUANTITY,TOTALPRICE,ADDRESS,ORDER_DATE from order_details  where user_id='1' order by order_date desc;
