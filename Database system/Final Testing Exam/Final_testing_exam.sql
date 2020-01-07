DROP DATABASE IF EXISTS QLBH;
CREATE DATABASE QLBH;
USE QLBH;

DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer (
	CustomerID	MEDIUMINT UNSIGNED AUTO_INCREMENT,
    `Name`		VARCHAR(15) NOT NULL,
    Phone		CHAR(10) NOT NULL,
    Email		VARCHAR(50),
    Address		VARCHAR(50),
    Note		VARCHAR(500),
-- CONSTRAINT	
PRIMARY KEY (CustomerID)
);

DROP TABLE IF EXISTS Car;
CREATE TABLE Car (
	CarID	MEDIUMINT UNSIGNED AUTO_INCREMENT,
    Maker	ENUM('HONDA','TOYOTA','NISSAN'),
    Model	VARCHAR(25),
    `YEAR`	MEDIUMINT UNSIGNED,
    Color	VARCHAR(15),
    Note	VARCHAR(500),
-- CONSTRAINT    
PRIMARY KEY (CarID),
CHECK (1111 < YEAR < 9999)
);

DROP TABLE IF EXISTS `ORDER`;
CREATE TABLE `Order` (
	OrderID			MEDIUMINT UNSIGNED AUTO_INCREMENT,
    CustomerID		MEDIUMINT UNSIGNED,
    CarID			MEDIUMINT UNSIGNED,
    Amount			TINYINT UNSIGNED DEFAULT 1,
    Saleprice		DECIMAL(8,2),
    Orderdate		DATE,
    DeliveryDate	DATE,
	DeliveryAddress	VARCHAR(50),
    `Status`		ENUM('0','1','2'),
    Note			VARCHAR(500),
-- CONSTRAINT
PRIMARY KEY (OrderID)
);

ALTER TABLE `Order`
	ADD	FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE CASCADE,
	ADD	FOREIGN KEY (CarID) REFERENCES Car(CarID) ON DELETE CASCADE;

-- -- ------------------------------------------------
INSERT INTO `car` 
VALUES 
  (
    1, 'HONDA', 'F150', 1992, 'Turquoise', 
    'et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam'
  ), 
  (
    2, 'TOYOTA', 'Z4', 2005, 'Crimson', 
    'eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue'
  ), 
  (
    3, 'NISSAN', 'Journey', 2010, 'Khaki', 
    'molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam'
  ), 
  (
    4, 'HONDA', 'Baja', 2006, 'Fuscia', 
    'vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor'
  ), 
  (
    5, 'TOYOTA', 'CRV-3000', 2011, 'Maroon', 
    'tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis'
  ), 
  (
    6, 'NISSAN', '7 Series', 2012, 'Green', 
    'vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non'
  ), 
  (
    7, 'HONDA', 'Sportvan G10', 1993, 'Puce', 
    'erat quisque erat eros viverra eget congue eget semper rutrum'
  ), 
  (
    8, 'TOYOTA', 'Samurai', 1995, 'Blue', 
    'non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa'
  ), 
  (
    9, 'NISSAN', 'Camry', 2003, 'Khaki', 
    'viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet'
  ), 
  (
    10, 'HONDA', 'Bonneville', 1990, 'Teal', 
    'pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus'
  ), 
  (
    11, 'TOYOTA', 'Solstice', 2009, 'Khaki', 
    'cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis'
  ), 
  (
    12, 'NISSAN', 'Silhouette', 1996, 'Puce', 
    'habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante'
  ), 
  (
    13, 'HONDA', 'Sentra', 1992, 'Yellow', 
    'sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie'
  ), 
  (
    14, 'TOYOTA', 'Savana 3500', 2003, 
    'Fuscia', 'lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer'
  ), 
  (
    15, 'NISSAN', 'Accord', 1983, 'Red', 
    'augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget'
  ), 
  (
    16, 'HONDA', 'Forester', 2000, 'Violet', 
    'ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id'
  ), 
  (
    17, 'TOYOTA', 'Thunderbird', 1984, 
    'Aquamarine', 'consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a'
  ), 
  (
    18, 'NISSAN', 'Thunderbolt-800', 1991, 
    'Pink', 'est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum'
  ), 
  (
    19, 'HONDA', 'LR2', 2008, 'Violet', 
    'mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis'
  ), 
  (
    20, 'TOYOTA', 'Silverado 2500', 2006, 
    'Purple', 'venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse'
  );
INSERT INTO `customer` 
VALUES 
  (
    1, 'Gianni', '6974431280', 'gpetrillo0@wisc.edu', 
    '110 Mifflin Hill', 'metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris'
  ), 
  (
    2, 'Hugibert', '5433944114', 'hgarling1@pen.io', 
    '814 Hagan Circle', 'nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis'
  ), 
  (
    3, 'Yancey', '8209618437', 'yhalladay2@weibo.com', 
    '69913 Esker Place', 'lorem ipsum dolor sit amet consectetuer adipiscing elit proin risus praesent lectus vestibulum quam sapien varius ut blandit non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in'
  ), 
  (
    4, 'Blinnie', '8539728995', 'bdikle3@tiny.cc', 
    '46 Bultman Crossing', 'eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus'
  ), 
  (
    5, 'Roz', '7925244029', 'rfearnley4@comcast.net', 
    '347 Ridgeway Park', 'non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis'
  ), 
  (
    6, 'Miles', '9788812387', 'mivashin5@kickstarter.com', 
    '4 Karstens Circle', 'quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus'
  ), 
  (
    7, 'Benton', '6306568445', 'bmadocjones6@youku.com', 
    '16662 Golf Course Hill', 'ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci'
  ), 
  (
    8, 'Lianne', '7409630861', 'lhockey7@printfriendly.com', 
    '3 Cascade Trail', 'in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis'
  ), 
  (
    9, 'Laure', '7575879291', 'lgindghill8@amazon.co.jp', 
    '312 Hallows Court', 'quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla'
  ), 
  (
    10, 'Ellyn', '6935222804', 'ehaversum9@mapy.cz', 
    '19626 Banding Lane', 'pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio'
  ), 
  (
    11, 'Lynea', '1838363268', 'leskrietta@storify.com', 
    '638 Oakridge Lane', 'risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien'
  ), 
  (
    12, 'Sharlene', '1865131080', 'sdjurkovicb@ameblo.jp', 
    '50 2nd Junction', 'aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien'
  ), 
  (
    13, 'Lani', '2529050089', 'lleguinc@nature.com', 
    '8 Bartelt Circle', 'luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus'
  ), 
  (
    14, 'Sammie', '4341837755', 'srusselld@sakura.ne.jp', 
    '129 Scoville Place', 'libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere'
  ), 
  (
    15, 'Kayne', '5899334761', 'kredborne@mac.com', 
    '5538 Lakewood Road', 'erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam'
  ), 
  (
    16, 'Rickard', '7746249882', 'rshenleyf@lulu.com', 
    '98907 Bluestem Junction', 'molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est'
  ), 
  (
    17, 'Karena', '7452373128', 'kgeartyg@hc360.com', 
    '41459 Schurz Avenue', 'mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae'
  ), 
  (
    18, 'Josey', '3639040979', 'jguth@sciencedaily.com', 
    '214 Pepper Wood Court', 'non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus'
  ), 
  (
    19, 'Dione', '5978179971', 'ddeetchi@nifty.com', 
    '7083 Leroy Way', 'sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec'
  ), 
  (
    20, 'Lisha', '2239915705', 'lgiffardj@bloglovin.com', 
    '4 Pierstorff Terrace', 'nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum'
  ), 
  (
    21, 'Paton', '3222764381', 'ppantingk@google.co.uk', 
    '84802 Longview Avenue', 'felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus sit amet nulla quisque arcu'
  ), 
  (
    22, 'Kala', '5149061750', 'kbentel@mediafire.com', 
    '047 Paget Park', 'ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam'
  ), 
  (
    23, 'Sheba', '2753515998', 'sgoodwellm@bloglovin.com', 
    '3 Melody Way', 'a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra'
  ), 
  (
    24, 'Wat', '3704270094', 'wrutherforthn@free.fr', 
    '59720 Northview Road', 'purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia'
  ), 
  (
    25, 'Corabella', '5467202968', 'cklampto@whitehouse.gov', 
    '106 Weeping Birch Street', 'odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at'
  ), 
  (
    26, 'Milt', '8713881882', 'mpitherickp@japanpost.jp', 
    '36071 Stang Terrace', 'at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est'
  ), 
  (
    27, 'Morgun', '9771181966', 'mvitteq@acquirethisname.com', 
    '82 Melody Alley', 'maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere'
  ), 
  (
    28, 'Wolfie', '1058813263', 'wdobler@goo.gl', 
    '282 Westend Trail', 'et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non'
  ), 
  (
    29, 'Cloe', '4221822100', 'chesses@behance.net', 
    '28 Muir Alley', 'iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi'
  ), 
  (
    30, 'Alexina', '6889871777', 'aeustont@gmpg.org', 
    '7 Darwin Avenue', 'metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero'
  ), 
  (
    31, 'Sigmund', '9482482805', 'srennixu@ed.gov', 
    '6201 Pankratz Plaza', 'ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt'
  ), 
  (
    32, 'Inglis', '9113758896', 'ivonwelldunv@dot.gov', 
    '8 Shasta Way', 'cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum'
  ), 
  (
    33, 'Lawton', '6609158923', 'lseabrookw@goo.ne.jp', 
    '949 Cordelia Place', 'turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac'
  ), 
  (
    34, 'Tally', '1926127034', 'tbrehenyx@phpbb.com', 
    '15 Crowley Lane', 'porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero'
  ), 
  (
    35, 'Fifine', '9645937317', 'frastricky@hp.com', 
    '18534 Fuller Point', 'ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum'
  ), 
  (
    36, 'Boycey', '4967840411', 'bandinoz@multiply.com', 
    '0 Hermina Plaza', 'posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet'
  ), 
  (
    37, 'Burnard', '2909532839', 'byoung10@globo.com', 
    '1663 East Point', 'posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend'
  ), 
  (
    38, 'Randi', '9951851158', 'resom11@epa.gov', 
    '1 Mifflin Pass', 'cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem'
  ), 
  (
    39, 'Zebulon', '2168535516', 'zferrettino12@clickbank.net', 
    '0 Kenwood Street', 'tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id'
  ), 
  (
    40, 'Rheta', '1254504510', 'rbrogiotti13@yellowbook.com', 
    '108 Surrey Drive', 'massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet'
  ), 
  (
    41, 'Renelle', '5289556464', 'rreynard14@google.com.br', 
    '949 Pearson Crossing', 'primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a'
  ), 
  (
    42, 'Wolfie', '4339291153', 'wtocknell15@wsj.com', 
    '0031 Eggendart Pass', 'posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede'
  ), 
  (
    43, 'Odette', '6242618441', 'obaudry16@goo.gl', 
    '311 Loeprich Terrace', 'in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit'
  ), 
  (
    44, 'Kathleen', '3101907589', 'kcresar17@mac.com', 
    '8 Jana Plaza', 'morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede'
  ), 
  (
    45, 'Colin', '4877288709', 'cnowlan18@patch.com', 
    '68 Dottie Street', 'amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient'
  ), 
  (
    46, 'Rolando', '4517235183', 'rdisney19@blogs.com', 
    '16080 Northfield Lane', 'mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla'
  ), 
  (
    47, 'Fionnula', '2578701791', 'fluthwood1a@linkedin.com', 
    '95 Emmet Parkway', 'non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui'
  ), 
  (
    48, 'Dorine', '7583444838', 'dbernaert1b@ocn.ne.jp', 
    '42566 Crownhardt Plaza', 'vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer'
  ), 
  (
    49, 'Karlie', '4321443252', 'kgreser1c@domainmarket.com', 
    '584 Merry Lane', 'leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam'
  ), 
  (
    50, 'Rayshell', '8055293981', 'rspadeck1d@arizona.edu', 
    '2 Duke Circle', 'duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis'
  );
INSERT INTO `order` 
VALUES 
  (
    1, 45, 4, 2, 2991.73, '2019-05-09', '2019-06-07', 
    '9701 Mcguire Circle', '1', 'aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer'
  ), 
  (
    2, 24, 10, 2, 3930.31, '2019-05-11', 
    '2019-06-12', '832 Chive Alley', 
    '0', 'libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices'
  ), 
  (
    4, 6, 17, 1, 2913.52, '2018-05-08', '2018-06-03', 
    '698 Jenna Avenue', '0', 'diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce'
  ), 
  (
    5, 34, 1, 2, 3625.78, '2019-05-05', '2019-06-11', 
    '965 Coolidge Terrace', '2', 'nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed'
  ), 
  (
    6, 21, 6, 1, 2629.34, '2019-05-01', '2019-06-11', 
    '776 Ilene Drive', '0', 'massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget'
  ), 
  (
    7, 46, 12, 2, 4921.89, '2019-05-05', 
    '2019-06-10', '722 Leroy Hill', 
    '1', 'at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in'
  ), 
  (
    8, 38, 11, 1, 2709.40, '2019-05-10', 
    '2019-06-07', '2 Barnett Drive', 
    '2', 'nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus sit amet nulla quisque arcu libero rutrum ac lobortis'
  ), 
  (
    9, 18, 19, 2, 2934.16, '2019-05-08', 
    '2019-06-02', '7 Lien Junction', 
    '2', 'tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae'
  ), 
  (
    10, 50, 7, 2, 4769.60, '2019-05-08', 
    '2019-06-01', '7 Mccormick Drive', 
    '1', 'sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt'
  ), 
  (
    11, 27, 7, 1, 3044.11, '2019-05-12', 
    '2019-06-14', '5581 Bayside Terrace', 
    '1', 'nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet'
  ), 
  (
    12, 15, 17, 2, 2753.75, '2019-05-02', 
    '2019-06-06', '66 Huxley Alley', 
    '0', 'porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac'
  ), 
  (
    13, 45, 11, 2, 3199.20, '2019-05-02', 
    '2019-06-04', '7568 Stone Corner Junction', 
    '2', 'turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero'
  ), 
  (
    14, 19, 15, 1, 4244.21, '2019-05-07', 
    '2019-06-08', '03 Sauthoff Street', 
    '0', 'ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo'
  ), 
  (
    15, 22, 9, 2, 3966.13, '2019-05-06', 
    '2019-06-06', '3 Sunbrook Pass', 
    '0', 'etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra'
  ), 
  (
    16, 26, 6, 3, 3098.74, '2019-05-07', 
    '2019-06-11', '12416 Miller Trail', 
    '2', 'id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet'
  ), 
  (
    17, 31, 6, 2, 4578.99, '2019-05-04', 
    '2019-06-07', '936 Independence Parkway', 
    '1', 'cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa'
  ), 
  (
    18, 6, 11, 2, 2782.13, '2019-05-14', 
    '2019-06-01', '40 New Castle Street', 
    '2', 'amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non'
  ), 
  (
    19, 11, 20, 2, 4506.34, '2019-05-06', 
    '2019-06-01', '38 Sachtjen Park', 
    '2', 'lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque'
  ), 
  (
    20, 34, 5, 1, 3078.92, '2019-05-04', 
    '2019-06-09', '77808 Crescent Oaks Hill', 
    '2', 'lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie'
  ), 
  (
    21, 11, 4, 1, 3637.87, '2019-05-11', 
    '2019-06-09', '2 Scoville Lane', 
    '1', 'tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus'
  ), 
  (
    22, 11, 1, 1, 3628.54, '2019-05-10', 
    '2019-06-04', '5252 Eggendart Street', 
    '0', 'vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus sit amet nulla quisque arcu libero rutrum ac lobortis vel dapibus'
  ), 
  (
    23, 36, 1, 2, 2773.53, '2019-05-02', 
    '2019-06-09', '273 Sutherland Circle', 
    '2', 'ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit'
  ), 
  (
    24, 29, 5, 1, 3373.86, '2019-05-04', 
    '2019-06-14', '10812 Golf Course Hill', 
    '1', 'nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor'
  ), 
  (
    25, 31, 10, 2, 3495.09, '2019-05-02', 
    '2019-06-09', '70915 Burrows Pass', 
    '2', 'donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere'
  ), 
  (
    26, 23, 3, 1, 4969.00, '2019-05-06', 
    '2019-06-08', '12143 Dakota Drive', 
    '1', 'fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis'
  ), 
  (
    27, 24, 19, 1, 3743.68, '2019-05-04', 
    '2019-06-13', '38 Mcguire Terrace', 
    '1', 'nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa'
  ), 
  (
    28, 20, 15, 1, 4193.86, '2019-05-05', 
    '2019-06-10', '782 Scoville Alley', 
    '0', 'magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac'
  ), 
  (
    29, 40, 3, 1, 4820.16, '2019-05-05', 
    '2019-06-12', '93582 John Wall Junction', 
    '0', 'at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh'
  ), 
  (
    30, 11, 17, 1, 3576.06, '2019-05-01', 
    '2019-06-10', '73355 Kings Trail', 
    '1', 'non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris'
  ), 
  (
    31, 20, 9, 1, 3929.97, '2019-05-11', 
    '2019-06-04', '52 Grayhawk Crossing', 
    '0', 'luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae'
  ), 
  (
    32, 13, 1, 1, 3900.89, '2019-05-04', 
    '2019-06-09', '026 5th Park', '0', 
    'pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean'
  ), 
  (
    33, 37, 2, 1, 2982.95, '2019-05-09', 
    '2019-06-10', '13331 Sutteridge Terrace', 
    '1', 'luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit'
  ), 
  (
    35, 37, 3, 1, 3636.28, '2019-05-14', 
    '2019-06-13', '810 Bowman Court', 
    '1', 'egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est'
  ), 
  (
    36, 45, 13, 1, 3792.76, '2019-05-03', 
    '2019-06-04', '5489 Shelley Parkway', 
    '2', 'pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus sit amet nulla quisque arcu libero'
  ), 
  (
    37, 34, 4, 1, 2906.45, '2019-05-01', 
    '2019-06-02', '21 Vermont Alley', 
    '0', 'pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in'
  );

-- ----------------------------------------------- CAU b
SELECT 	cus.`Name` AS 'Name',
		SUM(ord.Amount) AS 'Amount'
FROM `ORDER` ord
	JOIN Customer cus ON cus.CustomerID = ord.CustomerID
WHERE
    `Status` = '1'
    OR `Status` = '0'
GROUP BY ord.CustomerID
ORDER BY Amount;
-- ------------------------------------------------ CAU c
DELIMITER $$
DROP FUNCTION IF EXISTS Best_maker$$
CREATE FUNCTION Best_maker ()
RETURNS ENUM('HONDA','TOYOTA','NISSAN')
BEGIN
	DECLARE Result ENUM('HONDA','TOYOTA','NISSAN');
    DROP TEMPORARY TABLE IF EXISTS Amount;
	CREATE TEMPORARY TABLE Amount
	SELECT	car.Maker AS 'Maker',
			ord.Amount AS 'Amount'
    FROM `Order` ord
		JOIN Car ON ord.CarID = car.CarID
	WHERE `Status` = '1'
    HAVING YEAR(Current_date());
	
SELECT 
    Maker
INTO Result
FROM
    Amount
GROUP BY Maker
ORDER BY SUM(Amount) DESC
LIMIT 1;
    DROP TEMPORARY TABLE Amount;
	Return (Result);
END $$
DELIMITER ;
SELECT Best_maker();
-- ------------------------------------------------Cau d
DELIMITER $$
DROP PROCEDURE IF EXISTS Del_lyear$$
CREATE PROCEDURE Del_lyear	()
BEGIN
	SELECT Count(OrderID)
    FROM `Order`
    WHERE `Status` = '2'
		  AND DeliveryDate IN (SELECT DeliveryDate
							   FROM `Order`
							   WHERE `Status` = '2'
							   HAVING YEAR(DeliveryDate) < YEAR(Current_date()));
	
    WITH del_id (DeliveryDate) AS (
		SELECT DeliveryDate
		FROM `Order`
		WHERE `Status` = '2'
		HAVING YEAR(DeliveryDate) < YEAR(Current_date()))
	DELETE FROM `Order`
    WHERE `Status` = '2'
		  AND DeliveryDate IN (SELECT * FROM del_id);
END $$
DELIMITER ;
CALL Del_lyear();
-- ------------------------------------------------ Cau e
DELIMITER $$
DROP PROCEDURE IF EXISTS Find $$
CREATE PROCEDURE Find(IN ID MEDIUMINT UNSIGNED)
find:
BEGIN
	IF (ID NOT IN (SELECT OrderID FROM `ORDER`)) THEN
		BEGIN
			SELECT 'Can\'t Find Selected ID';
			LEAVE find;
		END;
	ELSE
		BEGIN
			SELECT 	cus.`Name` AS 'Name',
					ord.OrderID AS 'OrderID',
                    ord.Amount AS 'Amount',
					Car.Maker AS 'Maker'
            FROM `Order` ord
				JOIN Customer cus ON cus.CustomerID = ord.CustomerID
                JOIN Car ON car.CarID = ord.CarID
			WHERE ord.OrderID = ID;
        END;
    END IF;
END $$
DELIMITER ;
CALL Find(10);
-- ------------------------------------------------ Cau f
DELIMITER $$
DROP TRIGGER IF EXISTS Wrong_in $$
CREATE TRIGGER Wrong_in 
BEFORE INSERT ON `Order`
FOR EACH ROW
 BEGIN
	IF (NEW.DeliveryDate < DATE_ADD(NEW.OrderDate, INTERVAL 15 DAY)) THEN
		BEGIN
			 SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'Wrong Input: DeliveryDate < OrderDate + 15.';
        END;
    END IF;
 END$$
DELIMITER ;

INSERT INTO `Order`
VALUES (38, 41, 11, 1, 2906.45,	'2019-05-01', '2019-05-02', '21 Vermont Alley',	'0', 'pede lobortis');
