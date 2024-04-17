create database DB_BigWebservice
go
use DB_BigWebservice
go
create table Book(
Isbn varchar(15) not null primary key,
BookName nvarchar(100),
Author nvarchar(70),
Publisher nvarchar(100),
YearPubish int,
Pages int,
Price float)
insert into Book values ('B01',N'Hai Van Dam Duoi Bien',N'Nguyen Thuy Linh',N'NXB Kim Dong',2019,500,120000)
insert into Book values ('B02',N'Lap trinh HCJ',N'Nguyen Duc Nam',N'NXB Giao Duc',2020,200,50000)

select * from Book