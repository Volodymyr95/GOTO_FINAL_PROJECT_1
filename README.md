Welcome to Cryptanalyzer

<br>To get started, enter the arguments in this order:

<b>command filePath key</b>

+ <b>command</b> - three available options: [ENCRYPT, DECRYPT, BRUTE_FORCE]

+ <b>filepath</b> - absolute (full) path to the file to be encoded.

+ <b>key</b> - an integer, a key for shifting the alphabet. 

<br>If there are spaces or special characters in the path to the jar file or to the text file...

<b>(* / \ $ % & # @ ! ( ) { } [ ] , ; ' ” < > | ^ ~.`)</b>

...then enclose such a path in double quotes.

java -jar "c:/My Project/target/my App.jar" ENCRYPT "folder name/textFile1.txt" 20

<br>In case of transfer ENCRYPT/DECRYPT key is mandatory.

<br>As a result of the program, a file with the same name as the input file, but marked [ENCRYPTED] / [DECRYPTED] will appear in the folder with the initial file, depending on the operation performed.


<b>JavaRush</b>

Що вийшло зробити.

- Зроблено базовий функціонал програми із трьох методів ENCRYPT, DECRYPT, BRUTE_FORCE 

Що НЕ вийшло зробити з основних вимог.

Особливості проекту.

Які цікаві рішення реалізовані.

- Методи encrypt та decrypt шифрують та дешифрують текст на основі системи Юнікоду
- Метод bruteForceDecrypt працює не на методі статистичного аналізу (він часто показує неправильне дешифрування в малих та середніх текстах).
  Текст дешифрується 25 разів. Кожне дешифрування перевіряється на наявність у ній найпоширеніших англійських слів. Правильний ключ вважається той, текст якого містить найбільшу кількість слів з масиву рядків KeywordDictionary



На що варто звернути увагу ментором при перевірці.
- У головному класі повторюються деякі моменти, не знаю, як їх можна красивіше реалізувати.
- На все