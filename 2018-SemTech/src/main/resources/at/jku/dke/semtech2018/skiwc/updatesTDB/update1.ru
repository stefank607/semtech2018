PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX ski: <http://example.org/WeltCupGewinner> 
PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#>

INSERT DATA {
	:Man a rdfs:Class;
    rdfs:subClassOf :Person.
};

INSERT DATA {
	:hatGewonnen a rdf:Property;
        
        rdfs:domain :Skifahrer;
        
        rdfs:range :Weltcup.
}

INSERT DATA {
	:Women a rdfs:Class;
    rdfs:subClassOf :Person.
};

INSERT DATA { 
	:FranzKlammer  a :Skifahrer.
};

INSERT DATA{ 
	:MichaelaDorfmeister a :Skifahrer. 
};

INSERT DATA {
	:Abfahrtsweltcup1977 a :Weltcup.
};
