# TUTORIAL

------------------------

### Java:
Ultima versione ***ufficiale***: 8u131
    - [Windows](http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-windows-x64.exe)
    - [Mac](http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-macosx-x64.dmg)

Ultimissima versione ***sviluppatore***: 8u152
    - [Windows](http://download.java.net/java/jdk8u152/archive/b03/binaries/jdk-8u152-ea-bin-b03-windows-x64-19_apr_2017.exe)
    - [Mac](http://download.java.net/java/jdk8u152/archive/b03/binaries/jdk-8u152-ea-bin-b03-macosx-x86_64-19_apr_2017.dmg)

### NetBeans IDE:
Ultima versione: 8.2
    - [Windows](http://download.netbeans.org/netbeans/8.2/final/bundles/netbeans-8.2-javase-windows.exe)
    - [Mac](http://download.netbeans.org/netbeans/8.2/final/bundles/netbeans-8.2-javase-macosx.dmg)

## Windows:

#### Installazione:
1. Installare [Git](https://git-scm.com/download/win)
1. Registrarsi su [BitBucket](bitbucket.org)
1. Mandare la propria email al sommo capo

## Mac/Linux:
(Sia macOS che Linux hanno `git` preinstallato)

1. Registrarsi su [BitBucket](bitbucket.org)
1. Mandare la propria email al sommo capo

## Generale:

------------------------

#### Clonazione repo:
1. Quando siete stati aggiunti alla repo, aprire il terminale (cmd)
    e inserire il comando che potete trovare cliccando sulla voce "Clone" del menu laterale, sotto "Actions"

    **Necessario solo al primo accesso**

    >Questo copia tutta la repo dai server di BitBucket sul vostro PC, creando
    >una cartella con il nome della repo (in questo caso "Dallaz") e mettendo tutto
    >il contenuto dentro di essa

------------------------

#### Sincronizzazione del codice:
1. *Ad ogni accesso*, inserire nel cmd il comando `git pull`

    >Questo aggiorna il codice salvato in locale rispetto a quello nella repo, scaricando
    >le modifiche degli altri


1. *Dopo aver fatto delle modifiche*, inserire nel cmd il comando `git commit -m
    "Messaggio del commit"`, in "Messaggio del commit" deve contenere una piccola descrizione
    di cambiamenti/aggiunte. **Tenere le virgolette!**

    >Questo fa sapere alla repo quali file sono stati modificati e quindi vanno aggiornati
    >(git non carica sempre tutto quanto sulla repo, ma solo le modifiche, per risparmiare tempo)

    **Se un file prima non presente viene creato**, inserire prima il comando
        `git add -A`.

    >Questo fa sapere alla repo che va aggiunto un file che prima non esisteva

1. Dopo aver svolto il `commit`, inserire il comando `git push`

    >Questo carica i file modificati/creati sulla repo online, permettendo poi
    >agli altri di poter aggiornare i propri file locali


^_^
