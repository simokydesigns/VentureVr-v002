CREATE TABLE IF NOT EXISTS  user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    last_name varchar(40) NOT NULL,
    first_name varchar(40) NOT NULL,
    address varchar(40),
    contact_no varchar(64),
    email varchar(40),
    bio text(500)
);

CREATE TABLE IF NOT EXISTS  account (
    acc_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT(20) NOT NULL,
    user_name varchar(40) NOT NULL,
    password varchar(255) NOT NULL,
    acc_details varchar(255),
    date_account_created timestamp,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS  establishment (
    est_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    est_name varchar(40) NOT NULL,
    location varchar(40) NOT NULL,
    address varchar(255) NOT NULL,
    est_type varchar(40), 
    est_about text(510),
    est_img_name varchar(40) NOT NULL,
    est_img_path varchar(40) NOT NULL,
    est_img_format varchar(20),
    user_id BIGINT(20) NOT NULL,
    est_created varchar(40),
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON UPDATE CASCADE ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS  video (
    video_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    video_title varchar(40) NOT NULL,
    genre varchar(40) NOT NULL,
    path varchar(255) NOT NULL,
    file_type varchar(20), 
    est_id BIGINT(20),
    date_video_created timestamp,
    FOREIGN KEY (est_id) REFERENCES establishment(est_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS  image (
    img_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    img_name varchar(40) NOT NULL,
    img_path varchar(255) NOT NULL,
    img_type varchar(20), 
    est_id BIGINT(20),
    uploaded_date timestamp,
    FOREIGN KEY (est_id) REFERENCES establishment(est_id) ON UPDATE CASCADE ON DELETE CASCADE
);






