INSERT INTO role (role_name) VALUES
    ('admin'),
    ('employee');

INSERT INTO user (email, role_id, secured_password) VALUES
    ('Admin123@email.com', 1, '$argon2id$v=19$m=12,t=20,p=2$zF67un22ocu44k36$7+rzhNKs600R2lucUV1oUH/+Jy787fike14aYJSP4zc'),
    ('Employee123@email.com', 2, '$argon2id$v=19$m=12,t=20,p=2$r73eFJyTJN+IC59x$UYCJdZZkljs5CBP0LKS/gtmYAfiYnmGDLE1iMFOb4e8');

-- Insert statements for the job roles table
INSERT INTO job_role (job_role_name) VALUES
    ('Innovation Lead'),
    ('Technology Leader'),
    ('Software Engineer'),
    ('Software Engineer'),
    ('Support Technician'),
    ('Front-End Engineer'),
    ('Software Engineer'),
    ('Senior Support Technician'),
    ('Senior Front-End Engineer'),
    ('Senior Software Engineer'),
    ('Lead Managed Services Engineer'),
    ('Lead Software Engineer'),
    ('Technical Architect'),
    ('Solution Architect'),
    ('Dynamics 365 / Power Platform Solution Architect'),
    ('Principal Architect'),
    ('Test Engineer'),
    ('Test Engineer'),
    ('Senior NFT Engineer'),
    ('Senior Test Engineer'),
    ('Test Manager'),
    ('Lead NFT Engineer'),
    ('Lead Test Engineer'),
    ('Test Architect'),
    ('Principal Test Architect'),
    ('Product Specialist'),
    ('Senior Product Specialist'),
    ('Lead Product Specialist'),
    ('Intelligent Automation Solution Architect'),
    ('Low Code Engineer'),
    ('Low Code Engineer'),
    ('Low Code Principal Architect'),
    ('Head of Cloud Practice'),
    ('Lead Platform Engineer'),
    ('Senior Platform Engineer'),
    ('Platform Engineer'),
    ('Trainee Platform Engineer'),
    ('Principal Architect'),
    ('Solution Architect'),
    ('Technical Architect'),
    ('Senior Technical Specialist'),
    ('Cloud Economist'),
    ('Technical Specialist'),
    ('Cloud Migration Architect'),
    ('Cloud Migration Lead'),
    ('Head of IT Operations'),
    ('Systems Operations Manager'),
    ('Service Category Lead'),
    ('Lead Systems Support Engineer'),
    ('Service Category Lead'),
    ('Senior Systems Support Engineer'),
    ('Systems Support Engineer'),
    ('Trainee Systems Support Engineer'),
    ('Senior Systems Support Engineer'),
    ('Systems Support Engineer'),
    ('Trainee Systems Support Engineer'),
    ('Data Solution Architect'),
    ('Lead Data Technical Architect'),
    ('Lead Data Engineer'),
    ('Senior Data Engineer'),
    ('Data Engineer'),
    ('Trainee Data Engineer'),
    ('Principal Architect (Data and AI)'),
    ('Data Architect'),
    ('Data Architect'),
    ('AI Engineering Manager'),
    ('Lead AI Engineer'),
    ('Senior AI Engineer'),
    ('Associate AI Engineer'),
    ('Trainee AI Engineer'),
    ('Data Science Manager'),
    ('Consultant Data Scientist'),
    ('Senior Data Scientist'),
    ('Associate Data Scientist'),
    ('Trainee Data Scientist'),
    ('Principal Data and AI Consultant'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Data Migration Architect'),
    ('Data Analytics Manager'),
    ('Lead Data Analyst'),
    ('Senior Data Analyst'),
    ('Data Analyst'),
    ('Trainee Data Analyst'),
    ('Security Engineer'),
    ('Security Engineer'),
    ('Senior Security Engineer'),
    ('Security Architect, Lead Security Engineer'),
    ('Senior Security Architect'),
    ('Principal Security Architect'),
    ('Cyber Risk Assessor'),
    ('Security Analyst'),
    ('Senior Security Analyst'),
    ('Lead Security Analyst'),
    ('Corporate Security Manager'),
    ('Workday Practice Strategy and Planning Delivery Director'),
    ('HCM Solution Architect'),
    ('HCM Consultant'),
    ('HCM Consultant'),
    ('HCM Consultant'),
    ('HCM Consultant'),
    ('HCM Consultant'),
    ('Financials Solution Architect'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Financials Consultant'),
    ('Data Solution Architect'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Data Consultant'),
    ('Integrations Solution Architect'),
    ('Integrations Consultant'),
    ('Integrations Consultant'),
    ('Integrations Consultant'),
    ('Integrations Consultant'),
    ('Integrations Consultant'),
    ('Head of Change and User Adoption'),
    ('Change and User Adoption Solution Architect'),
    ('Change and User Adoption Consultant'),
    ('Change and User Adoption Consultant'),
    ('Change and User Adoption Consultant'),
    ('Change and User Adoption Consultant'),
    ('Change and User Adoption Consultant'),
    ('Adaptive Planning Solution Architect'),
    ('Adaptive Planning Solution Architect'),
    ('Adaptive Planning Consultant'),
    ('Adaptive Planning Consultant'),
    ('Adaptive Planning Consultant'),
    ('Head of Customer Engagement - Products'),
    ('Delivery Director'),
    ('Principal Test Manager'),
    ('Technical Lead'),
    ('Test Manager'),
    ('Test Consultant'),
    ('Test Consultant'),
    ('Test Consultant'),
    ('Test Consultant'),
    ('Principal Product Manager'),
    ('Product Manager'),
    ('Product Owner'),
    ('Product Marketing Consultant'),
    ('Product Owner'),
    ('Business Analyst'),
    ('Workday Extend Principal Architect'),
    ('Workday Extend Architect'),
    ('Workday Extend Architect'),
    ('Workday Extend Developer'),
    ('Workday Extend Developer'),
    ('Workday Extend Trainee'),
    ('Service Delivery Principal'),
    ('Advisory Principal'),
    ('Service Delivery Manager'),
    ('Advisory Manager'),
    ('Service Delivery Consultant'),
    ('Service Delivery Senior Associate'),
    ('Service Delivery Associate'),
    ('Service Delivery Associate'),
    ('User Researcher'),
    ('User Researcher'),
    ('User Researcher'),
    ('User Researcher'),
    ('User Researcher Lead'),
    ('Experience Design Principal'),
    ('Chief Design Officer'),
    ('Content Designer'),
    ('Content Designer'),
    ('Content Designer Lead'),
    ('Experience Design Principal'),
    ('Chief Design Officer'),
    ('UX Designer'),
    ('UX Designer'),
    ('UX Designer'),
    ('UX Designer'),
    ('UX Design Lead'),
    ('Experience Design Principal'),
    ('Chief Design Officer'),
    ('Service Designer'),
    ('Experience Strategy Lead'),
    ('Service Design Lead'),
    ('Experience Design Principal'),
    ('Chief Design Officer'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Product Consultant'),
    ('Digital Advisory Consultant'),
    ('Digital Advisory Consultant'),
    ('Digital Advisory Consultant'),
    ('Digital Advisory Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Low Code Consultant'),
    ('Delivery Lead'),
    ('Principal Delivery Manager'),
    ('Programme Manager'),
    ('Delivery Manager'),
    ('Engagement Manager'),
    ('Senior Agility Coach'),
    ('Team Lead'),
    ('Engagement Manager'),
    ('Agile Coach'),
    ('Delivery Manager'),
    ('Agile Practitioner'),
    ('Principal Engineering Manager'),
    ('Principal Service Manager'),
    ('Senior Service Manager'),
    ('Service Manager'),
    ('Service Lead'),
    ('Engagement Manager'),
    ('Engagement Manager'),
    ('Engagement Manager'),
    ('Engagement Manager'),
    ('Engagement Manager'),
    ('Programme Office Lead'),
    ('Programme Office Assistant'),
    ('Programme Office Assistant'),
    ('Programme Office Assistant'),
    ('Director of Operations'),
    ('Financial Operations Analyst'),
    ('Operations Manager'),
    ('Operations Manager'),
    ('Head of Operations'),
    ('Staffing Consultant'),
    ('Staffing Consultant'),
    ('Staffing and PMO Lead'),
    ('Global Head of Marketing'),
    ('Business Development Lead'),
    ('Account Lead'),
    ('Business Development Associate'),
    ('Senior Business Development Associate'),
    ('Business Development Consultant'),
    ('Business Development Manager'),
    ('Business Development Director'),
    ('Customer Success Associate'),
    ('Customer Success Consultant'),
    ('Customer Success Manager'),
    ('Customer Success Manager'),
    ('Customer Success Director'),
    ('Cloud Partner Operations Manager'),
    ('Partners Consultant'),
    ('Partners Relationship Manager'),
    ('Partners Director'),
    ('Senior Bid Production Associate'),
    ('Technical Pre-Sales Consultant'),
    ('Big Production Consultant'),
    ('Big Production Manager'),
    ('Big Production Director/Head of Product Presales'),
    ('Sales Development Representative'),
    ('Senior Sales Development Representative'),
    ('Sales Development Consultant'),
    ('Sales Development Manager'),
    ('Product Demand Generation Director'),
    ('Marketing Assistant'),
    ('Marketing Associate'),
    ('Marketing Executive'),
    ('Senior Marketing Executive'),
    ('Marketing Manager'),
    ('Marketing Director'),
    ('Martech and Ops Assistant'),
    ('Martech and Ops Associate'),
    ('Martech and Ops Executive'),
    ('Senior Martech and Ops Executive'),
    ('Marketing Operations Manager'),
    ('Digital Strategy Manager'),
    ('Digital Strategy Director'),
    ('Head of Practice'),
    ('Head of Quality and Compliance'),
    ('Chief Information Officer (CIO)'),
    ('Regional/Sector Lead'),
    ('Head of Planning and Strategic Initiatives'),
    ('Practice Lead'),
    ('Chief AI Officer'),
    ('Chief Executive Officer (CEO)'),
    ('Chief Financial Officer (CFO)'),
    ('Chief People Officer (CPO)'),
    ('Investor Relations'),
    ('Director of Innovation'),
    ('Business Unit (BU) Head'),
    ('BU Chief Operating Officer (COO)'),
    ('Vice President of Business Development'),
    ('Workday Practice Director of Product'),
    ('Regional/Sector Director'),
    ('Chief Revenue Officer'),
    ('Head of Strategic Partnering'),
    ('People Principal'),
    ('People Operations Manager'),
    ('People Operations Consultant'),
    ('Senior People Operations Associate'),
    ('People Operations Associate'),
    ('People Operations Trainee'),
    ('Head of Organisational Development & Learning'),
    ('Talent Development & Learning Principal'),
    ('Organisational Development & Learning Manager'),
    ('Internal Communications Manager'),
    ('Organisational Development & Learning Consultant'),
    ('Entry Level Partner'),
    ('Senior Organisational Development & Learning Associate'),
    ('Organisational Development & Learning Associate'),
    ('Global Head of Talent Acquisition'),
    ('Head of Talent Acquisition'),
    ('Talent Acquisition Manager'),
    ('Talent Acquisition Lead'),
    ('Talent Acquisition Partner'),
    ('Talent Acquisition Specialist'),
    ('Global Head of Commercial'),
    ('Group Head of Finance'),
    ('Senior Commercial Associate'),
    ('Commercial Consultant'),
    ('Commercial Manager'),
    ('Senior Commercial Manager'),
    ('Finance Trainee'),
    ('Finance Associate'),
    ('Senior Finance Associate'),
    ('Finance Consultant'),
    ('Finance Manager'),
    ('Group Financial Controller'),
    ('Payroll Trainee'),
    ('Payroll Associate'),
    ('Payroll Senior Associate'),
    ('Payroll Consultant'),
    ('Payroll Manager'),
    ('Head of Business Services Support'),
    ('Business Services Support Manager'),
    ('Business Services Support Consultant'),
    ('Senior Business Services Support Associate'),
    ('Business Services Support Associate'),
    ('Business Services Support Trainee'),
    ('Head of Property'),
    ('Property Manager'),
    ('Property Team Lead'),
    ('Head of Travel'),
    ('Travel Manager'),
    ('Travel Team Lead'),
    ('Head of Social Responsibility'),
    ('Social Responsibility Manager'),
    ('Education and Partnerships Lead'),
    ('Environmental Sustainability Lead'),
    ('Outreach and Engagement Senior Associate');

UPDATE job_role
SET specification_summary = 'As an Innovation Lead (Consultant) in Kainos, you’ll be responsible for leading efforts in providing advice and identifying new ways to use technology to solve customer problems. This is a dynamic and hands-on role which will involve leading the team, implementing and shaping Kainos’ innovation strategy and effectively communicating the exciting work we undertake both internally and within the wider technology community.', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Technology%20Leader%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 1;

UPDATE job_role
SET specification_summary = 'A technology leader is key strategic role within the business making executive technology decisions on behalf of the business, based upon the sector and practices’ strategic direction and goals.The core responsibilities of a technology leader in Kainos include setting a Technology direction, a technical advisor to the business and C-level clients, maintaining a commercial edge over other technology services providers, developing and nurturing technical talent across the organisation and representing Kainos as a technology evangelist.', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Technology%20Leader%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 2;

UPDATE job_role
SET specification_summary = 'The Kainos Earn as you Learn Programme is back! Our highly-regarded scheme gives the opportunity to work for us as an Apprentice Software Engineer four days per week, while studying for a part time degree in Computing Systems one day per week, with Ulster University, Jordanstown, completing your degree in just four and a half years. The best of both worlds! This is an excellent opportunity to combine real work and technical experience within our fast-changing company, with the formal studies that you need to progress your career in IT. It’s a no brainer! We’ll pay all of your University fees, provide you with a brandnew laptop as well as a full-time salary throughout.  Oh, and it doesn’t end there. You will be offered a permanent position with us from day one, and we’ll help you to quickly progress up our ranks with our excellent (and award-winning!) in-house training programme Kainos MAP. It’s a great way to compliment your studies.',
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Apprentice%20Software%20Engineer%20%28Apprentice%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 3;

UPDATE job_role
SET specification_summary = 'As a Trainee Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – the lives of people you know. After taking part in our award-winning, seven-week Engineering Academy, you will then join one of our many project teams, to learn from our experienced developers, project managers and customer-facing staff. You’ll have great support and mentoring, balanced with the experience of being given real, meaningful work to do, to help you truly develop both technically and professionally. ', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Software%20Engineer%20%28Trainee%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 4;

UPDATE job_role
SET specification_summary = 'As a Support Technician (Associate) in Kainos, you’ll be responsible for analysing and solving complicated technical issues. You will adhere to ITIL standards and will participate fully in the Incident management lifecycle. You will work closely with clients, internal teams and 3rd Party vendors to ensure that problems are resolved. You’ll do this whilst learning about new approaches, with talented colleagues that will help you to learn, develop and grow. ', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Support%20Technician%20%28As%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 5;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/sites/PeopleTeam-SharedDrive/Shared%20Documents/Forms/AllItems.aspx?id=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering%2FJob%20Profile%20%2D%20Front%2DEnd%20Engineer%20%28A%29%2Epdf&parent=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering'
WHERE job_role_id = 6;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Software%20Engineer%20%28Associate%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 7;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Senior%20Support%20Technician%20%28SA%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 8;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/sites/PeopleTeam-SharedDrive/Shared%20Documents/Forms/AllItems.aspx?id=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering%2FJob%20Profile%20%2D%20Senior%20Front%2DEnd%20Engineer%20%28SA%29%2Epdf&parent=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering'
WHERE job_role_id = 9;

UPDATE job_role
SET specification_summary = '', 
sharepoint_link = 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Senior%20Software%20Engieneer%20%28Senior%20Associate%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering'
WHERE job_role_id = 10;

-- Insert statements for job_family_group table
INSERT INTO job_family_group (job_family_group_name) VALUES 
	('Engineering'),
	('Platforms'),
	('Data and AI'),
	('Cyber Security'),
	('Workday'),
	('Experience Design'),
	('Product'),
	('Delivery'),
	('Operations'),
	('Business Development and Market'),
	('OS and Planning'),
	('People'),
	('Commercial and Financial Management'),
	('Business Services Support');
    
-- Insert statements for job_family table
INSERT INTO job_family (job_family_name, job_family_group_id) VALUES
    ('Engineering Strategy and Planning', 1),
    ('Engineering', 1),
    ('Architecture', 1),
    ('Testing and Quality Assurance', 1),
    ('Product Specialist', 1),
    ('Low Code Engineering', 1),
    ('Platform Strategy and Planning', 2),
    ('Platform Engineering', 2),
    ('Platform Architecture', 2),
    ('Platform Specialists', 2),
    ('Cloud Migration', 2),
    ('Systems Support', 2),
    ('Data Engineering', 3),
    ('Data Architecture', 3),
    ('Artificial Intelligence (AI) Engineering', 3),
    ('Data Science', 3),
    ('Data Consulting', 3),
    ('Data Analytics', 3),
    ('Security Strategy and Planning', 4),
    ('Security Engineering', 4),
    ('Corporate Security', 4),
    ('Strategy and Planning', 5),
    ('HCM', 5),
    ('Financials', 5),
    ('Data', 5),
    ('Integrations', 5),
    ('Change & User Adoption', 5),
    ('Adaptive Planning', 5),
    ('Product Services', 5),
    ('Product Development', 5),
    ('Extend', 5),
    ('Spend Management', 5),
    ('Insights', 6),
    ('Content Design', 6),
    ('UX / Visual Design', 6),
    ('Service Design', 6),
    ('Product Consultancy', 7),
    ('Digital Advisory Consultancy', 7),
    ('Low Code Consultancy', 7),
    ('Delivery Strategy & Planning', 8),
    ('Delivery Management', 8),
    ('Engineering Management', 8),
    ('Service Management', 8),
    ('Workday Engagement Management', 8),
    ('Programme Management Office (PMO)', 8),
    ('Operations Strategy and Planning', 9),
    ('Operational Management', 9),
    ('Staff Management', 9),
    ('Strategy and Planning', 10),
    ('Business Development', 10),
    ('Client Management', 10),
    ('Partners', 10),
    ('Bid Production', 10),
    ('Inside Sales', 10),
    ('Marketing – Business', 10),
    ('Marketing – Martech', 10),
    ('Organisational', 11),
    ('People Strategy and Planning', 12),
    ('People Operations / Strategic Partnering', 12),
    ('Engagement, Culture and Development', 12),
    ('Talent Acquisition', 12),
    ('Commercial and Financial Management Strategy & Planning', 13),
    ('Commercial', 13),
    ('Financial Management', 13),
    ('Payroll', 13),
    ('Business Services', 14),
    ('Property Management', 14),
    ('Travel Management', 14),
    ('Corporate Social Responsibility Management', 14);

UPDATE job_role
SET job_family_id = 1
WHERE job_role_id BETWEEN 1 AND 2;

UPDATE job_role
SET job_family_id = 2
WHERE job_role_id BETWEEN 3 AND 12;

UPDATE job_role
SET job_family_id = 3
WHERE job_role_id BETWEEN 13 AND 16;

UPDATE job_role
SET job_family_id = 4
WHERE job_role_id BETWEEN 17 AND 25;

UPDATE job_role
SET job_family_id = 5
WHERE job_role_id BETWEEN 26 AND 29;

UPDATE job_role
SET job_family_id = 6
WHERE job_role_id BETWEEN 20 AND 32;

SELECT * FROM job_role;

UPDATE job_role
SET job_family_id = 7
WHERE job_role_id = 33;

UPDATE job_role
SET job_family_id = 8
WHERE job_role_id BETWEEN 34 AND 37;

UPDATE job_role
SET job_family_id = 9
WHERE job_role_id BETWEEN 38 AND 40;

UPDATE job_role
SET job_family_id = 10
WHERE job_role_id BETWEEN 41 AND 43;

UPDATE job_role
SET job_family_id = 11
WHERE job_role_id BETWEEN 44 AND 45;

UPDATE job_role
SET job_family_id = 12
WHERE job_role_id BETWEEN 46 AND 56;

UPDATE job_role
SET job_family_id = 13
WHERE job_role_id BETWEEN 57 AND 62;

UPDATE job_role
SET job_family_id = 14
WHERE job_role_id BETWEEN 63 AND 65;

UPDATE job_role
SET job_family_id = 15
WHERE job_role_id BETWEEN 66 AND 70;

UPDATE job_role
SET job_family_id = 16
WHERE job_role_id BETWEEN 71 AND 75;

UPDATE job_role
SET job_family_id = 17
WHERE job_role_id BETWEEN 76 AND 79;

UPDATE job_role
SET job_family_id = 18
WHERE job_role_id BETWEEN 80 AND 84;

-- Insert statements for management_levels table
INSERT INTO management_level (management_level_name) VALUES
	('Leadership Community'),
	('Principal'),
	('Manager'),
	('Consultant'),
	('Senior Associate'),
	('Associate'),
	('Trainee'),
	('Apprentice');

UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 1;
UPDATE job_role SET management_level_id = 1 WHERE job_role_id = 2;
UPDATE job_role SET management_level_id = 8 WHERE job_role_id = 3;
UPDATE job_role SET management_level_id = 7 WHERE job_role_id = 4;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 5;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 6;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 7;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 8;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 9;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 10;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 11;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 12;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 13;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 14;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 15;
UPDATE job_role SET management_level_id = 2 WHERE job_role_id = 16;
UPDATE job_role SET management_level_id = 7 WHERE job_role_id = 17;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 18;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 19;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 20;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 21;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 22;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 23;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 24;
UPDATE job_role SET management_level_id = 2 WHERE job_role_id = 25;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 26;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 27;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 28;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 29;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 30;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 31;
UPDATE job_role SET management_level_id = 2 WHERE job_role_id = 32;

UPDATE job_role SET management_level_id = 1 WHERE job_role_id = 33;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 34;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 35;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 36;
UPDATE job_role SET management_level_id = 7 WHERE job_role_id = 37;
UPDATE job_role SET management_level_id = 2 WHERE job_role_id = 38;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 39;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 40;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 41;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 42;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 43;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 44;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 45;
UPDATE job_role SET management_level_id = 2 WHERE job_role_id = 46;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 47;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 48;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 49;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 50;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 51;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 52;
UPDATE job_role SET management_level_id = 7 WHERE job_role_id = 53;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 54;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 55;
UPDATE job_role SET management_level_id = 7 WHERE job_role_id = 56;

UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 57;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 58;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 59;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 60;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 61;
UPDATE job_role SET management_level_id = 7 WHERE job_role_id = 62;
UPDATE job_role SET management_level_id = 2 WHERE job_role_id = 63;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 64;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 65;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 66;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 67;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 68;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 69;
UPDATE job_role SET management_level_id = 7 WHERE job_role_id = 70;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 71;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 72;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 73;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 74;
UPDATE job_role SET management_level_id = 7 WHERE job_role_id = 75;
UPDATE job_role SET management_level_id = 2 WHERE job_role_id = 76;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 77;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 78;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 79;
UPDATE job_role SET management_level_id = 3 WHERE job_role_id = 80;
UPDATE job_role SET management_level_id = 4 WHERE job_role_id = 81;
UPDATE job_role SET management_level_id = 5 WHERE job_role_id = 82;
UPDATE job_role SET management_level_id = 6 WHERE job_role_id = 83;
UPDATE job_role SET management_level_id = 7 WHERE job_role_id = 84;

UPDATE job_role
SET responsibilities = 'Identifying, mentoring and coaching talent within the technical capabilities, supporting a culture of wellbeing and inclusion
Developing future technology talent aligned with the needs of the business in terms of strategic development and succession planning
Creating environments for technical talent to thrive and achieve ambitious goals
Conducting strategic analysis and make recommendations that could influence the business strategy over medium- and long-term horizons
Work with Innovation and business development teams to qualify and evidence strategic analysis
Managing the technology budget and making investments aligned to the business strategy
Review, question, and support development of Sector/Practice technology strategy
Uses cross cutting Sector/ Practice insights to identify business development opportunities where existing or future technologies can assist in solving existing or future business or client’s problems.
Inspiring potential and existing clients and employees within Kainos markets and driving change where necessary
Engaging with senior clients as a senior technical adviser. Establishing and developing trusted relationships that position Kainos as their technology partner of choice where strategic customer engagement is required'
WHERE job_role_id = 1;


UPDATE job_role
SET responsibilities = 'Collaborate with the Innovation Lead and Director of Innovation to shape the companys strategy for innovation and connect strategy with tactical implementation. 
Assume a leadership position in driving the approaches and tooling required for dynamic R&D projects.
Active engagement with the wider technology community, including conferences, meetups and events to continue to demonstrate thought leadership in public forums.
Identifying and implementing process improvements to improve the effectiveness of the innovation team. 
Taking responsibility for the Innovation Team’s internal and external communications strategy to share knowledge and demonstrate leadership both internally and in the public domain. 
Coordinating with other parts of the business, including presenting to internal and external customers. 
You’ll manage, coach and develop a number of staff, with a focus on managing employee performance and assisting in their career development.'
WHERE job_role_id = 2;


UPDATE job_role
SET responsibilities = 'As an Apprentice Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – the lives of people you know. 
Extensive training to set you off on the right foot, you will quickly work as a part of a team in developing solutions within our real projects, learning all about our development languages, projects and technologies. 
You will be fully supported by experienced colleagues in the team as well as an experienced mentor, who will provide training and mentoring throughout your studies. 
You’ll also get experience across a wide range of teams and projects, with built-in rotations to help you learn and work out which element of Software Engineering suits your interests and skills best. 
You’ll have a genuine enthusiasm for anything “tech” and be able to really show this, both within and outside of your studies. 
You’ll be able to show us your teamworking skills – everyone in Kainos works in tight-knit teams, so this is crucial. 
Our developers are creative – you’ll be able to show us your skills for coming up with new ideas and ways of doing things, how you’ve solved problems and looked at things differently.'
WHERE job_role_id = 3;

UPDATE job_role
SET responsibilities = 'Contribute to developing high quality solutions which impact the lives of users worldwide.
You’ll work as part of a team to solve problems and produce innovative software solutions.
Learn about new technologies and approaches, with talented colleagues who will help you learn, develop and grow.
Based in our Kainos office and often on our customer sites, you will work on a project teams to learn how to develop and unit test developing and unit testing straightforward or low complexity components, and then moving on to more complex elements as you increase your knowledge.
Work with other developers in working through designs and user stories and to produce real development solutions
Will be fully supported by experienced colleagues in the team to follow designs, and then progress to assist in any other aspect of the project life-cycle under supervision
Develop excellent technical, team-working and Agile project experience'
WHERE job_role_id = 4;

UPDATE job_role
SET responsibilities = 'Providing day-to-day technical support to internal and external customer.
Proactively taking ownership for incidents in areas of expertise and designated responsibility participating fully in the incident management lifecycle. 
Liaising with customers as required, presenting a professional image of Kainos, escalating, and reporting back to the Service Manager/Lead consultant. 
Configuring and solving issues within the relevant applications. 
Taking the lead in providing a support service to clients ensuring compliance with Service Level Agreements. 
Will have an awareness of overall client business requirements and impact on Kainos and client commercials. 
Delivering within commercial constraints that apply to the support agreement. 
Producing technical documentation and procedures as necessary within the relevant applications. 
Ensuring that deliverables are consistent with Kainos and/or client policies, strategies and constraints. 
Applying all relevant standards and procedures to their own work. 
Taking responsibility for team projects as required. 
Leading by example in both technical and non-technical aspects of the job. 
Recognising and raising business opportunities. 
Maintaining a current knowledge of relevant technology developments and actively shares knowledge. 
Advising customers on the technical, operational and business impacts of processes, incidents and RFCs. 
Involving development/infrastructure team/third parties as appropriate. 
Contributing to service review meetings. 
Complying with all confidentiality and non-disclosure policies and/or agreements and ensures security of information at all times.'
WHERE job_role_id = 5;

UPDATE job_role
SET responsibilities = 'Good communication skills, with the ability to communicate issues to other technical people, and sometimes to non-technical people.
Experience using version control systems such as git and with modern practices such as Continuous Integration / Continuous Delivery.
Experience with Typescript, Node.js, Express.js, npm/scripts and front-end build tools.
Understanding of accessibility best practices and experience creating accessible user interfaces.
Experience mentoring team members through knowledge-sharing and constructively contributing to code reviews and documentation.
Experience implementing and maintaining design systems or UI libraries.'
WHERE job_role_id = 6;

UPDATE job_role
SET responsibilities = 'Experience of building and testing modern software applications
Experience of applying common design principles and patterns
Experience of working in a collaborative team environment
You’re flexible and overcome obstacles to get the job done to achieve personal, team, and business goals.
You actively look for better ways to do things using your imagination to find fresh solutions to complex problems.
You are always constructive when giving or receiving feedback, being transparent and truthful when dealing with others.
You treat others as you would like to be treated being encouraging, accepting and supportive to everyone you deal with.
You share information, knowledge and experience, understanding the mutual benefits of team working.'
WHERE job_role_id = 7;


UPDATE job_role
SET responsibilities = 'Providing day-to-day technical support to internal and external customer.
Proactively taking ownership for incidents in areas of expertise and designated responsibility participating fully in the incident management lifecycle. 
Liaising with customers as required, presenting a professional image of Kainos, escalating, and reporting back to the Service Manager/Lead consultant. 
Configuring and solving issues within the relevant applications. 
Taking the lead in providing a support service to clients ensuring compliance with Service Level Agreements. 
Will have an awareness of overall client business requirements and impact on Kainos and client commercials. 
Delivering within commercial constraints that apply to the support agreement. 
Producing technical documentation and procedures as necessary within the relevant applications. 
Ensuring that deliverables are consistent with Kainos and/or client policies, strategies and constraints. 
Applying all relevant standards and procedures to their own work. 
Taking responsibility for team projects as required. 
Leading by example in both technical and non-technical aspects of the job. 
Recognising and raising business opportunities. 
Maintaining a current knowledge of relevant technology developments and actively shares knowledge. 
Advising customers on the technical, operational and business impacts of processes, incidents and RFCs. 
Involving development/infrastructure team/third parties as appropriate. 
Contributing to service review meetings. 
Complying with all confidentiality and non-disclosure policies and/or agreements and ensures security of information at all times.'
WHERE job_role_id = 8;

UPDATE job_role
SET responsibilities = 'Experience crafting quality, reusable front-end code with semantic HTML, CSS3/Sass, and object-oriented JavaScript/ES 6.
Experience building and testing modern data-driven front-end applications, consuming APIs, and delivering high quality user experiences using modern JavaScript frameworks such as Angular, Vue, React or similar.
Strong experience with browser dev tools; troubleshooting and debugging in test and live environments.
Knowledge of testing principles; experience writing unit tests for front-end components, integration tests and using modern testing tools.
Experience using version control systems such as git.
Experience contributing to technical discussions and direction in a collaborative team environment; including architecture, estimation, product planning and user story/requirement creation.
Able to make and communicate informed technical decisions by critically balancing user needs and technical/commercial constraints.
We are passionate about developing people – a demonstrated ability in managing, coaching and developing people in your team and the wider community.'
WHERE job_role_id = 9;

UPDATE job_role
SET responsibilities = 'Proficient in designing, building, testing and maintaining modern software applications.
Experience of applying development best practices and patterns in relation to security, scalability and performance.
Contributing to technical decisions and direction in a collaborative team environment, including architecture, estimation, product planning, user story/requirement creation.
Experience of design and development across multiple layers of an application.
Mentoring junior team members.'
WHERE job_role_id = 10;
