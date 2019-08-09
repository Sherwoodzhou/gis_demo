/*移动用户的数据*/
create table `event`(
`eventId` int(7),`deviceId` varchar(30),`timestamp` varchar(30),	`longitude` float (15),	`latitude` float (15)
);

ALTER TABLE `gis_demo`.`events`
MODIFY COLUMN `event_id` int(15) NOT NULL FIRST,
MODIFY COLUMN `device_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL AFTER `event_id`,
MODIFY COLUMN `timestamp` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL AFTER `device_id`,
MODIFY COLUMN `longitude` int(15) NOT NULL AFTER `timestamp`,
MODIFY COLUMN `latitude` int(15) NOT NULL AFTER `longitude`,
ADD PRIMARY KEY (`event_id`);

/*贵州危房数据*/
create table `dangerousHouse`(
`zip_code` int(15),`address` varchar (30),`count` int (30),`longitude` float (15),	`latitude` float (15)
);

CREATE TABLE `dangerousHouse` (
  `zip_code` int(15) NOT NULL,
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `count` int(30) NOT NULL,
  `longitude` float NOT NULL,
  `latitude` float NOT NULL,
   `finished` int(15) NOT NULL,
   `inprocess` int(15) NOT NULL,
   `nostart` int(15) NOT NULL,
   `nofound` int(15) NOT NULL,
   `inappropriate` int(15) NOT NULL,
   `proved` int(15) NOT NULL,
  PRIMARY KEY (`zip_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
