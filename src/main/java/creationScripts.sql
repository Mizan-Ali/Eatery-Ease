use eatery_ease;

CREATE TABLE `menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dish_name` VARCHAR(256) NOT NULL,
  `description` VARCHAR(1024) NULL,
  `price` INT NOT NULL,
  `available` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `dish_name_UNIQUE` (`dish_name` ASC) VISIBLE
);

CREATE TABLE `dining_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `table_name` VARCHAR(256) NOT NULL,
  `price` INT NOT NULL,
  `reserved` TINYINT(1) NOT NULL DEFAULT '0',
  `reserved_at` datetime,
  `reverve_duration` INT,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `table_name_UNIQUE` (`table_name` ASC) VISIBLE
);


CREATE TABLE `orders` (
  `id` int NOT NULL,
  `menu_id` int NOT NULL,
  `table_id` int NOT NULL,
  `is_paid` tinyint NOT NULL DEFAULT '0',
  `order_timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_menu_id_idx` (`menu_id`),
  KEY `fk_table_id_idx` (`table_id`),
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `fk_table_id` FOREIGN KEY (`table_id`) REFERENCES `dining_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci