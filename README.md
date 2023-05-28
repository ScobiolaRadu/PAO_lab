ETAPA 1

In aplicatie utilizatorul se poate loga ca admin sau ca si client dupa ce isi creeaza un cont.

Ca si admin optiunile sunt de a adauga/modifica/sterge/vedea instrumentele din fiecare categorie separata (chitare, tobe si piane).

Ca si client optiunile sunt de a vedea instrumentele din fiecare categorie, de a le adauga in cosul de cumparaturi si de a vizualiza cosul.

Clasele Guitar, Drums, Piano sunt derivate din clasa abstracta AbstractInstrument, iar clasele Client si Admin din clasa abstracta AbstractUser.
Clasele de tip service sunt folosite pentru toate operatiile cu instrumentele (o clasa diferita pentru fiecare), iar clasa ClientService este folosita pentru logarea clientului si gestionarea cosului de cumparaturi. 

ETAPA 2

Am adaugat o baza de date care retine fiecare instrument, clientii si cosurile acestora. Datele raman astfel salvate si dupa inchiderea aplicatiei.

Am adaugat un repository pentru fiecare serviciu.

Am adaugat un logger pentru fiecare accesare si iesire dintr-un meniu.

Programul creeaza un fisier csv cu toate chitarele aflate in stoc.
