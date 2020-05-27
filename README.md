# Dotty Experiment
Experimenting new syntaxes that is to be introduced by Dotty

## Setup

### Visual Studio Code
The only IDE that is officially supported is [Visual Studio Code](https://code.visualstudio.com/).
1) Install [Scala Metals](https://marketplace.visualstudio.com/items?itemName=scalameta.metals)
2) Open this project (_File / Open Folder_)

### intelliJ
You can also try intelliJ with Scala's nightly plugin:
1) Go to _Settings / Languages / Scala / Updates_
2) Select _Nightly_ plugin update channel and press _Check for updates_

However the syntax highlight doesn't seem to work well

## Usage
You can run this project with `sbt run`.
`sbt console` will start a Dotty REPL.

For more information on the sbt-dotty plugin, see the
[dotty-example-project](https://github.com/lampepfl/dotty-example-project/blob/master/README.md).
