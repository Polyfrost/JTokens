# Java Design Tokens

This is a general purpose library to parse [JSON design tokens](https://tr.designtokens.org/).

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
- [ ] [Composite types](https://tr.designtokens.org/format/#composite-types) (NOT FINALIZED IN STANDARD)
  - [ ] Stroke style
  - [ ] Border
  - [X] Transition
  - [X] Shadow
  - [X] Gradient
  - [X] Typography