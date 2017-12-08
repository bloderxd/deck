# Deck

![alt_tag](https://bloximages.chicago2.vip.townnews.com/journaltimes.com/content/tncms/assets/v3/editorial/4/48/4484cfa4-e685-5fb8-9b05-3d3df399ac06/57838be8937b3.image.jpg)

# What is it?

Deck is a library that permits you to apply a beautiful animation in your view pager, and this animations looks like a deck... yeah, I'm not good with names.

![alt_tag](https://media.giphy.com/media/l4EpiKjC1H2sQCVva/giphy.gif)

# How does it works?

First of all you need to declare it in your layout xml file

```xml
<com.example.lib.Deck
        android:id="@+id/deck_pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

then you just need to set deck default padding

```kotlin
private val deckPager by lazy { activity.findViewById<Deck>(R.id.deck_pager) }

private fun initDeck() {
    deckPager.useDefaultPadding(activity)
}

```

##### Remember you can set all other view pager properties with deck

# Import

It's easy import deck in your project, first you need add jit pack maven reference in your project

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

then add deck referente in your gradle dependencies

##### Gradle

```groovy
dependencies {
    compile 'com.github.bloderxd:deck:0.1'
}
```

##### Gradle v3.0+
```groovy
dependencies {
    implementation 'com.github.bloderxd:deck:0.1'
}
```

# License

```
MIT License

Copyright (c) 2017 Bloder

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
