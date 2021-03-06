Create database e_commercail_testing;
Use e_commercail_testing;
CREATE TABLE Products(PRODUCT_ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(100), PRICE DECIMAL(10,2));
CREATE TABLE Users(USER_ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(100), REG_TIME TIMESTAMP);

CREATE TABLE Orders 
(ORDER_ID INT PRIMARY KEY AUTO_INCREMENT,
USER_ID INT,
CREATE_TIME TIMESTAMP,
PRODUCT_ID INT,
PRODUCT_COUNT INT,
foreign key(USER_ID) references Users(USER_ID),
foreign key(PRODUCT_ID) references Products(PRODUCT_ID));
