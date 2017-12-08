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
