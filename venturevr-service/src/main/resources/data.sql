/*INSERT INTO user (user_id, first_name, last_name, address, contact_no, email, bio)
VALUES (NULL,'Simon', 'Kelly', 'Cahaska', '0833681914', 'simok@eircom.net','Lorem ipsum dolor sit amet, 
mea ornatus fabellas electram ei. Ne alii diam eos, duo eu apeirian volutpat. Cum an simul iudico luptatum, 
homero percipitur vel in. Tamquam persequeris usu te. Mei et detracto deleniti constituam, saperet ceteros 
mel ex, eu mei quidam graecis scaevola. Adipiscing definiebas cotidieque vix ea, ne antiopam pertinacia per.

Moderatius constituam vituperatoribus ad vix, graeco eruditi ea usu. Eu vis dolore tractatos elaboraret, cu 
probo admodum singulis vim. Ne nec putent menandri, at menandri recusabo vix. Vix case menandri voluptatum ut.
 Utamur appetere accusamus et qui. Suas pericula efficiendi et per.

Mea tempor nominati voluptatum in. Ex nulla vituperata contentiones eos, oportere concludaturque ea nec. His 
ut audire recusabo. Ea est dico nihil gubergren, esse iriure id vim, tota porro te sea. Ea tota quas ius, et 
errem elaboraret usu.');
INSERT INTO user (user_id, first_name, last_name, address, contact_no, email, bio)
VALUES (NULL,'Frank', 'O Reilly', 'galway', '0833681914', 'frank@eircom.net', 'Lorem ipsum dolor sit amet, 
mea ornatus fabellas electram ei. Ne alii diam eos, duo eu apeirian volutpat. Cum an simul iudico luptatum, 
homero percipitur vel in. Tamquam persequeris usu te. Mei et detracto deleniti constituam, saperet ceteros 
mel ex, eu mei quidam graecis scaevola. Adipiscing definiebas cotidieque vix ea, ne antiopam pertinacia per.

Moderatius constituam vituperatoribus ad vix, graeco eruditi ea usu. Eu vis dolore tractatos elaboraret, cu 
probo admodum singulis vim. Ne nec putent menandri, at menandri recusabo vix. Vix case menandri voluptatum 
ut. Utamur appetere accusamus et qui. Suas pericula efficiendi et per.

Mea tempor nominati voluptatum in. Ex nulla vituperata contentiones eos, oportere concludaturque ea nec. His 
ut audire recusabo. Ea est dico nihil gubergren, esse iriure id vim, tota porro te sea. Ea tota quas ius, 
et errem elaboraret usu.');

INSERT INTO establishment (est_id, est_name, location, address, est_type, est_about, est_img_name, est_img_path, est_img_format, user_id, est_created)
VALUES (NULL, 'SimokyDesigns', 'Corofin', 'Cahaska road', 'Software Developer', 'I am an all-round developer who feels
 comfortable programming as well as designing.  I am passionate about web/application development with Java being my core
 language. I have experience with J2EE, JSP’s and web services Rest/Soap. I have also learnt C# and been involved in many 
projects using Unity 3D. My last role was recently with SAP cloud Team as a full stack developer. Being an ambitious 
self-learner who can research solutions to problems independently, I am always open to acquiring new knowledge and skills.
Please click on the portfolio link to view projects I have worked on.', 'IMG_2158', 'webapp/img/est-upload-img/', 'jpg', 1, 'sep/2016');
INSERT INTO establishment (est_id, est_name, location, address, est_type, est_about, est_img_name, est_img_path, est_img_format, user_id, est_created)
VALUES (NULL, 'New Bar', 'Corofin', 'main road', 'Sports Bar', 'Lorem ipsum dolor sit amet, 
mea ornatus fabellas electram ei. Ne alii diam eos, duo eu apeirian volutpat. Cum an simul iudico luptatum, 
homero percipitur vel in. Tamquam persequeris usu te. Mei et detracto deleniti constituam, saperet ceteros 
mel ex, eu mei quidam graecis scaevola. Adipiscing definiebas cotidieque vix ea, ne antiopam pertinacia per.

Moderatius constituam vituperatoribus ad vix, graeco eruditi ea usu. Eu vis dolore tractatos elaboraret, cu 
probo admodum singulis vim. Ne nec putent menandri, at menandri recusabo vix. Vix case menandri voluptatum 
ut. Utamur appetere accusamus et qui. Suas pericula efficiendi et per.

Mea tempor nominati voluptatum in. Ex nulla vituperata contentiones eos, oportere concludaturque ea nec. His 
ut audire recusabo. Ea est dico nihil gubergren, esse iriure id vim, tota porro te sea. Ea tota quas ius, 
et errem elaboraret usu.', 'SDC11599', 'webapp/img/est-upload-img/', 'jpg', 2, 'Mar/1986');


INSERT INTO video (video_id, video_title, genre, path, file_type, est_id, date_video_created)
VALUES (NULL, 'venture', 'VR travel', 'webapp/video/', 'webm', 1, NULL);
INSERT INTO video (video_id, video_title, genre, path, file_type, est_id, date_video_created)
VALUES (NULL, 'vr_roller_coaster', 'Triller', 'webapp/video/', 'webm', 2, NULL);

INSERT INTO account (acc_id, user_id, user_name, password, acc_details, date_account_created)
VALUES (NULL, '1', 'simon', '123', 'acc1234545ff', NULL);
INSERT INTO account (acc_id, user_id, user_name, password, acc_details, date_account_created)
VALUES (NULL, '1', 'frank', '456', 'acc34577hhueih8', NULL);

INSERT INTO image (img_id, img_name, img_path, img_type, est_id, uploaded_date)
VALUES (NULL, 'IMG_2158', 'webapp/img/est-upload-img/', 'jpg', 1, NULL);
INSERT INTO image (img_id, img_name, img_path, img_type, est_id, uploaded_date)
VALUES (NULL, 'SDC11599', 'webapp/img/est-upload-img/', 'jpg', 2, NULL);*/

