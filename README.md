
# ariereframe2

###What is this?
This is a single-page application zenius prestasi template that uses zenius prestasi question caller as html tag.

###The base template includes:
* [re-frame](https://github.com/Day8/re-frame)
* [figwheel](https://github.com/bhauman/lein-figwheel)

###How to use
First, simply clone this repo into your computer.

Then in resources/public/index.html you will see:
```
<!doctype html>
<html lang="en">
  <head>
    <meta charset='utf-8'>
    
    
  </head>
  <body>
    <div id="app"></div>
    <p> <b>Persamaan simpel!</b> </p>
    <p> Coba jawab: </p>
    <question id="q1"></question>
    <p>Kalo lo jawabnya bener brarti lo lulus TK. Sekarang coba yang lebih menantang:</p>
	<question id="q2"></question>
	<p>Kalo lo jawabnya bener, selamat! Lo udah menguasai perkalian simpel! Sekarang coba:</p>
    <question id="q3"></question>
    <p>Bisa jawab lagi? Mungkin lo ga butuh belajar di modul ini.</p>
    <question id="q4"></question>
    <p>Hus-hus sono!</p>
    
    <script src="js/compiled/app.js"></script>
    <script>ariereframe2.core.init();</script>
  </body>
</html>
```
### Run application:
```cd``` to your directory,
then type:
```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

