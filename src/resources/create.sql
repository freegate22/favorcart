CREATE TABLE `folder` (
  `folder_id` int(11) NOT NULL AUTO_INCREMENT,
  `folder_name` varchar(100) NOT NULL,
  PRIMARY KEY (`folder_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `bookmark` (
  `bookmark_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `bookmark_name` varchar(100) NOT NULL,
  `bookmark_url` text NOT NULL,
  PRIMARY KEY (`bookmark_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
	`user_id`		VARCHAR(64) NOT NULL,
	`user_password`	CHAR(64) NOT NULL,
	PRIMARY KEY(`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
