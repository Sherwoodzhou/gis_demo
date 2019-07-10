create table `events`(
`event_id` int(15),`device_id` varchar(30),`timestamp` varchar(30),	`longitude` int (15),	`latitude` int (15)
);

ALTER TABLE `gis_demo`.`events`
MODIFY COLUMN `event_id` int(15) NOT NULL FIRST,
MODIFY COLUMN `device_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL AFTER `event_id`,
MODIFY COLUMN `timestamp` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL AFTER `device_id`,
MODIFY COLUMN `longitude` int(15) NOT NULL AFTER `timestamp`,
MODIFY COLUMN `latitude` int(15) NOT NULL AFTER `longitude`,
ADD PRIMARY KEY (`event_id`);