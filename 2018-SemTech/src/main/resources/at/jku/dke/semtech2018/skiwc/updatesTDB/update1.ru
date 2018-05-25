PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX : <http://example.org/> 
PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#>

#################################################################
#
#    Classes
#
#################################################################

INSERT DATA {
	:Man a rdfs:Class;
    rdfs:subClassOf :Person.
};

INSERT DATA {
	:Women a rdfs:Class;
    rdfs:subClassOf :Person.
};

INSERT DATA {
	:GesamtWC a rdfs:Class;
		rdfs:subClassOf :Weltcup.
};

INSERT DATA {
	:RiesentorWC a rdfs:Class;
		rdfs:subClassOf :Weltcup.
};

INSERT DATA {
	:SlalomWC a rdfs:Class;
		rdfs:subClassOf :Weltcup.
};

INSERT DATA {
	:AbfahrtsWC a rdfs:Class;
		rdfs:subClassOf :Weltcup.
};

INSERT DATA {
	:KombiWC a rdfs:Class;
		rdfs:subClassOf :Weltcup.
};

INSERT DATA {
	:SuperGWC a rdfs:Class;
		rdfs:subClassOf :Weltcup.
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
	:hatGeschlecht a rdf:Property;
		rdfs:domain :Person;
		rdfs:range :Geschlecht.
};

#################################################################
#
#    Individuals
#
#################################################################


INSERT DATA { 
	:FranzKlammer  a :Skifahrer.
};

INSERT DATA{ 
	:MichaelaDorfmeister a :Skifahrer. 
};

INSERT DATA {
	:Abfahrtsweltcup1977 a :Weltcup.
};

INSERT DATA {
	:FranzKlammer :hatGewonnen :Abfahrtsweltcup1977
};

INSERT DATA {
	:Abfahrtsweltcup1977 :hatStattgefunden :1977
};
