create table types(
		idType serial not NULL ,
		idTypeSupp int,
		idTypeInf int,
		libelle varchar(25)
	);

	create table typesAtt(
		idTypeAtt serial not NULL ,
		libelle varchar(25)
	);

	create table typesLieu(
		idTypeLieu serial not NULL ,
		idTypeFort int references types,
		idTypeFaible int references types,
		libelle varchar(25)
	);

	create table lieu(
		idLieu serial not NULL ,
		idTypeLieu int references typesLieu,
		nom varchar(25)
	);

	create table attaques(
		id serial not NULL ,
		damages int,
		nom varchar(25),
		nbrUses int,
		idType int references types,
		idTypeAtt int references typesAtt,
		lvlAprent int
	);

	create table familles(
		id serial not NULL ,
		rang int,
		libelle varchar(25),
		lvlPassageR2 int,
		lvlPassageR3 int
	);

	create table espece(
		id serial not NULL ,
		nomEspece varchar(25),
		idLieuCapt int references lieu,
		hp int,
		att int,
		arm int,
		pui int,
		res int,
		vit int,
		idType1 int references types,
		idType2 int references types,
		idFamille int references familles,
		tauxCapt int
	);

	create table cubes(
		id serial not NULL ,
		libelle varchar(25),
		tauxReuss int
	);

	create table gwenAdopte(
		id serial not NULL ,
		nom varchar(25),
		niveau int,
		idGwenamon int references espece,
		idAttaque1 int references attaques,
		idAttaque2 int references attaques,
		idAttaque3 int references attaques,
		idAttaque4 int references attaques,
		idCubeMaison int references cubes
	);

	create table equipe(
		id serial not NULL ,
		gwenAdopte1 int references gwenAdopte,
		gwenAdopte2 int references gwenAdopte,
		gwenAdopte3 int references gwenAdopte,
		gwenAdopte4 int references gwenAdopte,
		gwenAdopte5 int references gwenAdopte,
		gwenAdopte6 int references gwenAdopte
	);

	create table objSoin(
		id serial not NULL ,
		nom varchar(25),
		hpsRendus int
	);

	create table typeDresseur(
		idTypeDress serial not NULL ,
		libelle varchar(25)
	);

	create table dresseurs(
		id serial not NULL ,
		nom varchar(25),
		idTypeDress int references typeDresseur,
		idEquipe int references equipe,
		idLieu int references lieu
	);


------------------------------------------------------------------
insert into types(libelle) values ('eau');
insert into types(libelle) values ('plante');
insert into types(libelle) values ('feu');
insert into types(libelle) values ('dragon');
insert into types(libelle) values ('spectre');
insert into types(libelle) values ('fée');
insert into types(libelle) values ('psy');
insert into types(libelle) values ('ténèbres');
insert into types(libelle) values ('poison');
insert into types(libelle) values ('normal');
update types set idTypeSupp = 1 WHERE idType = 3;
update types set idTypeSupp = 2 WHERE idType = 1;
update types set idTypeSupp = 3 WHERE idType = 2;
update types set idTypeInf = 1 WHERE idType = 2;
update types set idTypeInf = 2 WHERE idType = 3;
update types set idTypeInf = 3 WHERE idType = 1;
update types set idTypeSupp = 4 WHERE idType = 6;
update types set idTypeSupp = 5 WHERE idType = 4;
update types set idTypeSupp = 6 WHERE idType = 5;
update types set idTypeInf = 4 WHERE idType = 5;
update types set idTypeInf = 5 WHERE idType = 6;
update types set idTypeInf = 6 WHERE idType = 4;
update types set idTypeSupp = 7 WHERE idType = 9;
update types set idTypeSupp = 8 WHERE idType = 7;
update types set idTypeSupp = 9 WHERE idType = 8;
update types set idTypeInf = 7 WHERE idType = 8;
update types set idTypeInf = 8 WHERE idType = 9;
update types set idTypeInf = 9 WHERE idType = 7;
------------------------------------------------------------------
insert into typesAtt(libelle) values ('physique');
insert into typesAtt(libelle) values ('psychique');
------------------------------------------------------------------
insert into typesLieu(idTypeFort,idTypeFaible,libelle) values (2,1,'forêt');
insert into typesLieu(idTypeFort,idTypeFaible,libelle) values (1,3,'mer');
insert into typesLieu(idTypeFort,idTypeFaible,libelle) values (1,3,'lac');
insert into typesLieu(idTypeFort,idTypeFaible,libelle) values (3,1,'volcan');
insert into typesLieu(idTypeFort,libelle) values (8,'grotte');
insert into typesLieu(libelle) values ('arène');
insert into typesLieu(libelle) values ('plaine');
insert into typesLieu(libelle) values ('village');
insert into typesLieu(libelle) values ('ville');
------------------------------------------------------------------
insert into lieu(idTypeLieu, nom) values (8,'Bourg-Patate');
insert into lieu(idTypeLieu, nom) values (1,'Forêt test');
------------------------------------------------------------------
insert into attaques(damages, nom, nbrUses, idType, idTypeAtt, lvlAprent)
	values (60,'charge',30,10,1,3);
insert into attaques(damages, nom, nbrUses, idType, idTypeAtt, lvlAprent)
	values (160,'Feu OP',5,3,2,100);
insert into attaques(damages, nom, nbrUses, idType, idTypeAtt, lvlAprent)
	values (100,'Ulti Shyv',10,4,1,50);
------------------------------------------------------------------
insert into familles(rang, libelle, lvlPassageR2, lvlPassageR3) values (3,'GardevoirF',15,30);
insert into familles(rang, libelle, lvlPassageR2, lvlPassageR3) values (1,'AelF');
------------------------------------------------------------------
insert into espece(nomEspece, idLieuCapt, hp, att, arm, pui, res, vit, idType1, idFamille, tauxCapt)
	values ('Tarsal',2,25,12,7,48,65,100,7,1,3);
insert into espece(nomEspece, idLieuCapt, hp, att, arm, pui, res, vit, idType1, idType2, idFamille, tauxCapt)
	values ('Kirlia',2,25,12,7,48,65,100,6,7,1,12);
insert into espece(nomEspece, idLieuCapt, hp, att, arm, pui, res, vit, idType1, idType2, idFamille, tauxCapt)
	values ('Gardevoir',2,25,12,7,48,65,100,6,7,1,50);
insert into espece(nomEspece, idLieuCapt, hp, att, arm, pui, res, vit, idType1, idType2, idFamille, tauxCapt)
	values ('Ael',2,25,12,7,48,65,100,5,8,2,);
------------------------------------------------------------------
insert into cubes(libelle, tauxReuss) values ('GwenaCube',1);
insert into cubes(libelle, tauxReuss) values ('MegaCube',2);
insert into cubes(libelle, tauxReuss) values ('HyperCube',3);
insert into cubes(libelle, tauxReuss) values ('UltimaCube',255);
------------------------------------------------------------------
insert into gwenAdopte(nom,niveau,idGwenamon,idAttaque1,idAttaque2,idAttaque3,idCubeMaison)
	values ('Patate',100,1,1,2,3,1);
insert into gwenAdopte(nom,niveau,idGwenamon,idAttaque1,idAttaque2,idAttaque3,idCubeMaison)
	values ('Francis',100,2,1,2,3,2);
insert into gwenAdopte(nom,niveau,idGwenamon,idAttaque1,idAttaque2,idAttaque3,idCubeMaison)
	values ('Rhapsody',100,3,1,2,3,3);
insert into gwenAdopte(nom,niveau,idGwenamon,idAttaque1,idAttaque2,idAttaque3,idCubeMaison)
	values ('Gwen',100,4,1,2,3,4);
------------------------------------------------------------------
insert into equipe(idGwenAdopte1, idGwenAdopte2, idGwenAdopte3, idGwenAdopte4, idGwenAdopte5, idGwenAdopte6)
	values (1,2,3,3,2,4);
insert into equipe(idGwenAdopte1, idGwenAdopte2, idGwenAdopte3, idGwenAdopte4, idGwenAdopte5, idGwenAdopte6)
	values (1,1,1,1,2,2);
insert into equipe(idGwenAdopte1, idGwenAdopte2, idGwenAdopte3, idGwenAdopte4, idGwenAdopte5, idGwenAdopte6)
	values (2,2,2,2,2,2);
insert into equipe(idGwenAdopte1, idGwenAdopte2, idGwenAdopte3, idGwenAdopte4, idGwenAdopte5, idGwenAdopte6)
	values (2,2,1,3,2,1);
------------------------------------------------------------------
insert into objSoin(nom, hpsRendus) values ('Potion',50);
insert into objSoin(nom, hpsRendus) values ('MegaPotion',120);
insert into objSoin(nom, hpsRendus) values ('HyperPotion',180);
insert into objSoin(nom, hpsRendus) values ('UltimaSoin',900);
------------------------------------------------------------------
insert into typeDresseur(libelle) values ('Président');
insert into typeDresseur(libelle) values ('Gamin');
insert into typeDresseur(libelle) values ('Champion');
insert into typeDresseur(libelle) values ('TopDresseur');
------------------------------------------------------------------
insert into dresseurs(nom, idTypeDress, idEquipe, idLieu) values ('Albert',1,1,1);
insert into dresseurs(nom, idTypeDress, idEquipe, idLieu) values ('Thomas',2,2,1);
insert into dresseurs(nom, idTypeDress, idEquipe, idLieu) values ('Victor',3,3,1);
insert into dresseurs(nom, idTypeDress, idEquipe, idLieu) values ('Mahel',4,4,1);
