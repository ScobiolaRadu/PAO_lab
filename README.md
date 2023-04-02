ETAPA 1

In aplicatie utilizatorul se poate loga ca admin sau ca si client dupa ce isi creeaza un cont.

Ca si admin optiunile sunt de a adauga/modifica/sterge/vedea instrumentele din fiecare categorie separata (chitare, tobe si piane).

Ca si client optiunile sunt de vedea instrumentele din fiecare categorie, de a le adauga in cosul de cumparaturi si de a vizualiza cosul.

Clasele Guitar, Drums, Piano sunt derivate din clasa abstracta AbstractInstrument, iar clasele Client si Admin din clasa abstracta AbstractUser.
Clasele de tip service sunt folosite pentru toate operatiile cu instrumentele (o clasa diferita pentru fiecare), iar clasa ClientService este folosita pentru logarea clientului si gestionarea cosului de cumparaturi. 
