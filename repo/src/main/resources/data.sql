INSERT INTO role VALUES(1, 'ROLE_ADMIN');
INSERT INTO role VALUES(2, 'ROLE_USER');

INSERT INTO user VALUES(1, 'frankie@gmail.com', 'Frank', '$2a$10$U69SsCaSBlI/x4X7WaZrMuTCjHGWwj1DzacR1706zabQlihWaztr.', 'Frankie');

INSERT INTO user_role VALUES(1, 1);

INSERT INTO study_program VALUES(1, 'ISiT', '2014');
INSERT INTO study_program VALUES(2, 'Management', '2013');

INSERT INTO department VALUES(1, 'Artificial Intelligence');
INSERT INTO department VALUES(2, 'Software Engineering');
INSERT INTO department VALUES(3, 'Economics');
INSERT INTO department VALUES(4, 'Business Development');

INSERT INTO course VALUES(null, 6, "Da se nauci matematika", "Mathematics", "Mandatory", 2, 1);
INSERT INTO course VALUES(null, 5, "Da se nauci matematika", "Intelligent systems", "Optional", 1, 1);
INSERT INTO course VALUES(null, 6, "Da se nauci matematika", "Advanced java technologies", "Mandatory", 2, 1);
INSERT INTO course VALUES(null, 5, "Da se nauci matematika", "Intro to programing", "Mandatory", 2, 1);
INSERT INTO course VALUES(null, 5, "Da se nauci matematika", "Java 2", "Optional", 1, 1);
INSERT INTO course VALUES(null, 5, "Da se nauci matematika", "Macroeconomics", "Optional", 3, 1);
INSERT INTO course VALUES(null, 6, "Da se nauci matematika", "Economic indicators", "Mandatory", 3, 2);
INSERT INTO course VALUES(null, 6, "Da se nauci matematika", "Market research", "Mandatory", 4, 2);
INSERT INTO course VALUES(null, 6, "Da se nauci matematika", "Business models", "Mandatory", 4, 2);
INSERT INTO course VALUES(null, 4, "Da se nauci matematika", "Strategic management", "Optional", 4, 2);
INSERT INTO course VALUES(null, 5, "Da se nauci matematika", "Software patterns", "Mandatory", 2, 1);
INSERT INTO course VALUES(null, 6, "Da se nauci matematika", "Microeconomics", "Mandatory", 3, 2);
INSERT INTO course VALUES(null, 6, "Da se nauci matematika", "Data science", "Mandatory", 1, 1);

INSERT INTO lecturer VALUES('P', null, 'Frank Fransis', 'AI', null, 'Full Professor', 41, 1);
INSERT INTO lecturer VALUES('P', null, 'Anne Bush', 'Data science', null, 'Associate Professor', 33, 1);
INSERT INTO lecturer VALUES('P', null, 'Nicolas Harr', 'Functional programming', null, 'Full Professor', 40, 2);
INSERT INTO lecturer VALUES('P', null, 'Tina Henderson', 'User experience', null, 'Associate Professor', 41, 2);
INSERT INTO lecturer VALUES('A', null, 'Becky Solace', 'Linear models', 'Masters', null, null, 1);
INSERT INTO lecturer VALUES('A', null, 'Frank Sinatra', 'NLP', 'Bachelor', null, null, 1);
INSERT INTO lecturer VALUES('A', null, 'Thomas Moore', 'Software architectures', 'Masters', null, null, 2);
INSERT INTO lecturer VALUES('A', null, 'Samuel L Jackson', 'System programming', 'Masters', null, null, 2);
INSERT INTO lecturer VALUES('P', null, 'Sarah Connor', 'Microeconomics', null, 'Full Professor', 29, 3);
INSERT INTO lecturer VALUES('P', null, 'Michael Moore', 'International trade', null, 'Associate Professor', 10, 3);
INSERT INTO lecturer VALUES('P', null, 'George Clooney', 'Business management', null, 'Full Professor', 35, 4);
INSERT INTO lecturer VALUES('P', null, 'Jessica Marie Fransis', 'Technological management', null, 'Associate Professor', 15, 4);
INSERT INTO lecturer VALUES('A', null, 'Niki Benz', 'Economics in politics', 'Masters', null, null, 3);
INSERT INTO lecturer VALUES('A', null, 'Lidija Savic', 'International economics', 'Bachelor', null, null, 3);
INSERT INTO lecturer VALUES('A', null, 'Jimi Hendrix', 'Corporate communication', 'Bachelor', null, null, 4);
INSERT INTO lecturer VALUES('A', null, 'Tom Cruise', 'Market analysis', 'Masters', null, null, 4);

INSERT INTO course_unit VALUES(null, 'Some description', 'Discrete mathemathics', 1, 1);