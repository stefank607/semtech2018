PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX : <http://example.org/> 
PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#>

#################################################################
#
#    Classes
#
#################################################################

INSERT DATA {
	:Skifahrer a rdfs:Class;
};

INSERT DATA {
	:Weltcup a rdfs:Class;
};

#################################################################
#
#    Object Properties
#
#################################################################

INSERT DATA {
	:hatGewonnen a rdf:Property;     
        rdfs:domain :Skifahrer;  
        rdfs:range :Weltcup.    
};

INSERT DATA {
	:hatStattgefunden a rdf:Property;
		rdfs:domain :Weltcup;
		rdfs:range :Jahr.
};

INSERT DATA {
	:hatVornamen a rdf:Property;
		rdfs:domain :Person;
		rdfs:range rdfs:Literal;
};

INSERT DATA {
	:hatNachnamen a rdf:Property;
		rdfs:domain :Person;
		rdfs:range rdfs:Literal;
};

INSERT DATA {
	:hatBezeichnung a rdf:Property;
		rdfs:domain :Weltcup;
		rdfs:range: rdfs:Literal;
};

#################################################################
#
#    Individuals - Skifahrer
#
#################################################################


INSERT DATA { 
	:HannesReichelt  a :Skifahrer.
};

INSERT DATA {
	:HannesReichelt :hatVornamen "Hannes".
};

INSERT DATA {
	:HannesReichelt :hatNachnamen "Reichelt".
};

INSERT DATA { 
	:RenateGoetschl  a :Skifahrer.
};

INSERT DATA {
	:RenateGoetschl :hatVornamen "Renate".
};

INSERT DATA {
	:RenateGoetschl :hatNachnamen "Goetschl".
};

INSERT DATA { 
	:FranzKlammer  a :Skifahrer.
};

INSERT DATA {
	:FranzKlammer :hatVornamen "Franz".
};

INSERT DATA {
	:FranzKlammer :hatNachnamen "Klammer".
};

INSERT DATA {
	:NicoleHosp a :Skifahrer.
};

INSERT DATA {
	:NicoleHosp :hatVornamen "Nicole".
};

INSERT DATA {
	:NicoleHosp :hatNachnamen "Hosp".
};

INSERT DATA{ 
	:MichaelaDorfmeister a :Skifahrer. 
};

INSERT DATA {
	:MichaelaDorfmeister :hatVornamen "Michaela".
};

INSERT DATA {
	:MichaelaDorfmeister :hatNachnamen "Dorfmeister".
};

INSERT DATA {
	:MarcelHirscher a :Skifahrer.
};

INSERT DATA {
	:MarcelHirscher :hatVornamen "Marcel".
};

INSERT DATA {
	:MarcelHirscher :hatNachnamen "Hirscher".
};

INSERT DATA { 
	:BenjaminRaich  a :Skifahrer.
};

INSERT DATA {
	:BenjaminRaich :hatVornamen "Benjamin".
};

INSERT DATA {
	:BenjaminRaich :hatNachnamen "Raich".
};

INSERT DATA { 
	:HermannMaier  a :Skifahrer.
};

INSERT DATA {
	:HermannMaier :hatVornamen "Hermann".
};

INSERT DATA {
	:HermannMaier :hatNachnamen "Maier".
};

INSERT DATA { 
	:StephanEberharter  a :Skifahrer.
};

INSERT DATA {
	:StephanEberharter :hatVornamen "Stephan".
};

INSERT DATA {
	:StephanEberharter :hatNachnamen "Eberharter".
};
INSERT DATA { 
	:FranzKlammer  a :Skifahrer.
};

INSERT DATA {
	:FranzKlammer :hatVornamen "Franz".
};

INSERT DATA {
	:FranzKlammer :hatNachnamen "Klammer".
};

INSERT DATA { 
	:BrigitteTotschnig  a :Skifahrer.
};

INSERT DATA {
	:BrigitteTotschnig :hatVornamen "Brigitte".
};

INSERT DATA {
	:BrigitteTotschnig :hatNachnamen "Totschnig".
};

INSERT DATA { 
	:PetraKronberger  a :Skifahrer.
};

INSERT DATA {
	:PetraKronberger :hatVornamen "Petra".
};

INSERT DATA {
	:PetraKronberger :hatNachnamen "Kronberger".
};

#################################################################
#
#    Individuals - Weltcups
#
#################################################################

INSERT DATA {
	:SuperGweltcup2007 a :Weltcup.
};

INSERT DATA {
	:SuperGweltcup2007 :hatBezeichnung "Super-G Weltcup 2007".
};

INSERT DATA {
	:SuperGweltcup2007 :hatStattgefunden :2007.
};

INSERT DATA {
	:SuperGweltcup2003 a :Weltcup.
};

INSERT DATA {
	:SuperGweltcup2003 :hatBezeichnung "Super-G Weltcup 2003".
};

INSERT DATA {
	:SuperGweltcup2003 :hatStattgefunden :2003.
};

INSERT DATA {
	:Abfahrtsweltcup1977 a :Weltcup.
};

INSERT DATA {
	:Abfahrtsweltcup1977 :hatBezeichnung "Abfahrtsweltcup 1977".
};

INSERT DATA {
	:Abfahrtsweltcup1977 :hatStattgefunden :1977.
};

INSERT DATA {
	:Abfahrtsweltcup2002 a :Weltcup.
};

INSERT DATA {
	:Abfahrtsweltcup2002 :hatStattgefunden :2002.
};

INSERT DATA {
	:Abfahrtsweltcup2002 :hatBezeichnung "Abfahrtsweltcup 2002".
};

INSERT DATA {
	:Gesamtweltcup2017 a :Weltcup.
};

INSERT DATA {
	:Gesamtweltcup2017 :hatBezeichnung "Gesamtweltcup 2017".
};

INSERT DATA {
	:Gesamtweltcup2017 :hatStattgefunden :2017.
};

INSERT DATA {
	:Gesamtweltcup2006 a :Weltcup.
};

INSERT DATA {
	:Gesamtweltcup2006 :hatBezeichnung "Gesamtweltcup 2006".
};

INSERT DATA {
	:Gesamtweltcup2006 :hatStattgefunden :2006.
};
INSERT DATA {
	:Gesamtweltcup2004 a :Weltcup.
};

INSERT DATA {
	:Gesamtweltcup2004 :hatBezeichnung "Gesamtweltcup 2004".
};
INSERT DATA {
	:Gesamtweltcup2004 :hatStattgefunden :2004.
};
INSERT DATA {
	:SuperG2002 a :Weltcup.
};

INSERT DATA {
	:SuperG2002 :hatBezeichnung "Super-G Weltcup 2002".
};
INSERT DATA {
	:SuperG2002 :hatStattgefunden :2002.
};
INSERT DATA {
	:Abfahrt1982 a :Weltcup.
};

INSERT DATA {
	:Abfahrt1982 :hatBezeichnung "Abfahrt Weltcup 1982".
};
INSERT DATA {
	:Abfahrt1982 :hatStattgefunden :1982.
};
INSERT DATA {
	:Abfahrt1976 a :Weltcup.
};

INSERT DATA {
	:Abfahrt1976 :hatBezeichnung "Abfahrt Weltcup 1976".
};
INSERT DATA {
	:Abfahrt1976 :hatStattgefunden :1976.
};
INSERT DATA {
	:Gesamtweltcup1990 a :Weltcup.
};

INSERT DATA {
	:Gesamtweltcup1990 :hatBezeichnung "Gesamt Weltcup 1990".
};
INSERT DATA {
	:Gesamtweltcup1990 :hatStattgefunden :1990.
};

#################################################################
#
#    Individuals - hatGewonnen Beziehungen
#
#################################################################

INSERT DATA {
	:HannesReichelt :hatGewonnen :SuperGweltcup2007.
};

INSERT DATA {
	:RenateGoetschl :hatGewonnen :SuperGweltcup2003.
};

INSERT DATA {
	:FranzKlammer :hatGewonnen :Abfahrtsweltcup1977.
};

INSERT DATA {
	:NicoleHosp :hatGewonnen :Gesamtweltcup2006.
};

INSERT DATA {
	:MichaelaDorfmeister :hatGewonnen :Abfahrtsweltcup2002.
};

INSERT DATA {
	:MarcelHirscher :hatGewonnen :Gesamtweltcup2017.
};
INSERT DATA { 
	:BenjaminRaich  :hatGewonnen :Gesamtweltcup2006.
};


INSERT DATA { 
	:HermannMaier  :hatGewonnen :Gesamtweltcup2004.
};

INSERT DATA { 
	:StephanEberharter  :hatGewonnen :SuperG2002.
};

INSERT DATA { 
	:FranzKlammer  :hatGewonnen :Abfahrt1982.
};


INSERT DATA { 
	:BrigitteTotschnig  :hatGewonnen :Abfahrt1976.
};

INSERT DATA { 
	:PetraKronberger  :hatGewonnen :Gesamtweltcup1990.
};


