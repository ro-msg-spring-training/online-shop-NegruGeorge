
CREATE TABLE IF NOT EXISTS Location (
        Id int not null AUTO_INCREMENT PRIMARY KEY,
        Namee varchar(100),
        Country varchar(100),
        City varchar(100),
        County varchar(100),
        StreetAddress varchar(256)
    );

create table if not exists ProductCategory(
    Id int not null AUTO_INCREMENT primary key,
    Namee varchar(100),
    Description varchar(256)

);

create table if not exists Supplier(
    Id int not null AUTO_INCREMENT primary key,
    Namee varchar(100)

);

create table if not exists Customer(
    Id int not null AUTO_INCREMENT primary key,
    FirstName varchar(100),
    LastName varchar(100),
    Username varchar(100),
    Password varchar(100),
    EmailAddress varchar(100)
);

CREATE TABLE IF NOT EXISTS Product  (

    Id int NOT NULL AUTO_INCREMENT primary key,
    Namee varchar(100),
    Description varchar(256),
    Price decimal,
    Weight double,
    IdCategory int,
    IdSupplier int,
    ImageURL varchar(256),
    Foreign key (IdCategory) references ProductCategory(Id),
    foreign key (IdSupplier) references Supplier(Id)
    );



Create table if not exists Stock(
    IdProduct int NOT NULL,
    IdLocation int NOT NULL,
    Quantity int,
    foreign key (IdProduct) references Product(Id),
    foreign key (IdLocation) references Location(Id),
    primary key (IdProduct,IdLocation)

);



create table if not exists Orderr(
    Id int not null AUTO_INCREMENT primary key,
    IdShippedFrom int,
    IdCustomer int,
    CreatedAt DATE,
    Country varchar(100),
    City varchar(100),
    County varchar(100),
    StreetAdress varchar(1000),
    foreign key (IdShippedFrom) references Location(Id),
    foreign key (IdCustomer) references Customer(Id)
);


create table if not exists OrderDetail(
    IdOrderr int AUTO_INCREMENT NOT NULL,
    IdProduct int NOT NULL,
    Quantity int,
    foreign key (IdOrderr) references Orderr(Id),
    foreign key (IdProduct) references Product(Id),
    primary key (IdOrderr,IdProduct)
);

create table if not exists Revenue(
    Id int not null AUTO_INCREMENT primary key,
    IdLocation int,
    Datee DATE,
    Suma double,
    foreign key (IdLocation) references Location(Id)
);



