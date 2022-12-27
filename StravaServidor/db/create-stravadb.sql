/* DELETE 'stravadb' database*/
DROP SCHEMA IF EXISTS stravaDB;
/* DELETE USER 'strava_user' AT LOCAL SERVER*/
DROP USER IF EXISTS 'strava_user'@'%';

/* CREATE 'stravadb' DATABASE */
CREATE SCHEMA IF NOT EXISTS stravaDB;
/* CREATE THE USER 'strava_user' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER IF NOT EXISTS 'strava_user'@'%' IDENTIFIED BY 'password';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'strava_user' AT LOCAL SERVER*/
GRANT ALL ON stravaDB.* TO 'strava_user'@'%';