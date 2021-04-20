CREATE DATABASE giftappdb
GO

USE giftappdb
GO

-- Create tables
CREATE TABLE account (
    uname VARCHAR(20) NOT NULL,
    passwd varchar(50) NOT NULL,
    acctype INT NOT NULL, -- 0: admin | 1: nomal

    PRIMARY KEY(uname)
)
GO

CREATE TABLE accountInfo (
    uname VARCHAR(20) REFERENCES dbo.account(uname),
    disName NVARCHAR(100) NOT NULL,
    uaddress NTEXT,
    phonenum INT NOT NULL,

	PRIMARY KEY(uname)
)
GO

CREATE TABLE item (
	cid INT,
	iname NVARCHAR(100) NOT NULL,
	idescription NTEXT NOT NULL,
	thumbnailimg NVARCHAR(200) NOT NULL DEFAULT 'https://www.apple.com/ac/structured-data/images/open_graph_logo.png?201810040211',
	price INT NOT NULL DEFAULT 0,

	activeState INT NOT NULL DEFAULT 1, -- 1: on

	PRIMARY KEY(cid)
)
GO

CREATE TABLE giftpack (
	cid INT,
	gname NVARCHAR(100) NOT NULL,
	gdescription NTEXT NOT NULL,
	thumbnailimg NVARCHAR(200) NOT NULL DEFAULT 'https://www.apple.com/ac/structured-data/images/open_graph_logo.png?201810040211',
	price INT NOT NULL DEFAULT 0,
	averageStar INT NOT NULL DEFAULT 0, -- from 1 to 5

	activeState INT NOT NULL DEFAULT 1, -- 1: on

	PRIMARY KEY(cid)
)
GO

CREATE TABLE giftpackitems (
	cid INT,
	giftpackId INT REFERENCES dbo.giftpack(cid) NOT NULL,
	itemId INT REFERENCES dbo.item(cid) NOT NULL,

	PRIMARY KEY(cid)
)
GO

CREATE TABLE giftpackComments (
	cid INT,
	giftpackId INT REFERENCES dbo.giftpack(cid) NOT NULL,
	uname VARCHAR(20) REFERENCES dbo.account(uname) NOT NULL,
	content NTEXT NOT NULL,

	PRIMARY KEY(cid)
)
GO

CREATE TABLE gevaluate (
	cid INT REFERENCES dbo.giftpack(cid),
	uname VARCHAR(20) UNIQUE REFERENCES dbo.account(uname),
	star INT NOT NULL, -- from 1 to 5

	PRIMARY KEY(cid, uname)
)
GO

CREATE TABLE addon (
	cid INT,
	aname VARCHAR(20) NOT NULL,
	adescription NTEXT NOT NULL,
	price INT NOT NULL DEFAULT 0,

	PRIMARY KEY(cid)
)
GO

CREATE TABLE gorder (
	cid INT,
	uname VARCHAR(20) REFERENCES dbo.account(uname) NOT NULL,
	giftpackId INT REFERENCES dbo.giftpack(cid) NOT NULL,
	receiveAdress NTEXT NOT NULL,
	phoneNumber INT NOT NULL,
	dateOrder DATETIME NOT NULL,
	dateArrive DATETIME NOT NULL,
	greetingCardContent NTEXT NOT NULL DEFAULT 'Have a nice day!',

	PRIMARY KEY(cid)
)
GO

CREATE TABLE gorderAddons (
	cid INT,
	gorderId INT REFERENCES dbo.gorder(cid) NOT NULL,
	addonId INT REFERENCES dbo.addon(cid) NOT NULL,
	content NTEXT,

	PRIMARY KEY(cid)
)
GO

CREATE TABLE orderProcess (
	goderId INT REFERENCES dbo.gorder(cid),
	pstate NTEXT NOT NULL,
	pdelivered INT NOT NULL DEFAULT 0,
	pcanceled INT NOT NULL DEFAULT 0,

	PRIMARY KEY(goderId)
)
GO
