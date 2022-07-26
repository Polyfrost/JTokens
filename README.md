# JTokens

JTokens is a general purpose library to parse [JSON design tokens](https://tr.designtokens.org/).

## Including JTokens

Groovy:
```groovy
repositories {
  maven { url "https://repo.polyfrost.cc/releases" }
}

dependencies {
  implementation("cc.polyfrost.jtokens:1.0.0") 
}
```
Kotlin:
```kotlin
repositories {
  maven("https://repo.polyfrost.cc/releases")
}

dependencies {
  implementation("cc.polyfrost.jtokens:1.0.0")
}
```

## Usage

### Creating a DesignToken

json can be a `JsonObject`, Json String, `Reader` or `JsonReader`
```java
DesignToken token = new DesignToken(json);
```
You can load multiple jsons like so:
```java
DesignToken token = new DesignToken(json1, json2);
```

### Getting values

Example design token json;
```json
{
  "colors": {
    "$type": "color",
    "white": {
      "$value": "#ffffff"
    }
  }
}
```
To get the white color do the following:
```java
Color white = token.getColor("colors.white");
```

### Custom types

JTokens allows you to use custom types, to do this implement the TypeResolutionStrategy class or extend the DefaultTypeResolutionStrategy class, then use it like this:
```java
DesignToken token = new DesignToken(new MyTypeResolutionStrategy(), json);
```

## Checklist

- [X] [Basic JSON types](https://tr.designtokens.org/format/#type-0)
- [X] [Aliases / references](https://tr.designtokens.org/format/#aliases-references)
- [X] [Types](https://tr.designtokens.org/format/#types)
    - [X] Color
    - [X] Dimension
    - [X] Font Family (NOT FINALIZED IN STANDARD)
    - [X] Font Weight
    - [X] Duration
    - [X] Cubic Bezier
- [X] Allow loading of multiple files and references to the other file in the same design token instance
- [X] [Extensions](https://tr.designtokens.org/format/#extensions)
- [X] [Composite types](https://tr.designtokens.org/format/#composite-types) (NOT FINALIZED IN STANDARD)
  - [X] Stroke style
  - [X] Border
  - [X] Transition
  - [X] Shadow
  - [X] Gradient
  - [X] Typography