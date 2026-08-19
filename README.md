<p align="center"><img src="docs/banner.svg" alt="ObsidianExpansion" width="100%"></p>

# ObsidianExpansion

> ### 🏰 ¡Únete a la Comunidad Oficial de DrakesCraft!
> 
> * 🎮 **IP del Servidor**: `play.drakescraft.net` *(Java 1.21.11 & Bedrock)*
> * 💬 **Discord Oficial**: [discord.gg/drakescraft](https://discord.gg/rR7FbfCt9Y)
> * 🌐 **Web & Guía**: [drakescraft.net](https://drakescraft.net) — 🛒 **Tienda**: [tienda.drakescraft.net](https://tienda.drakescraft.net)
> 
> *¡Juega con este addon y más de 80 expansiones optimizadas en vivo en nuestra network de supervivencia técnica!*

---

Una rama tecnológica entera alrededor de la obsidiana, adaptada al ecosistema Slimefun de
**DrakesCraft** (Paper/Purpur 1.21.11, Java 21).

## Qué añade

**Compresión.** Obsidiana Comprimida en cinco niveles, de 9 bloques hasta 59.049. Es la moneda de
la rama: casi todo lo demás se fabrica con ella.

**Generadores.** El Generador de Obsidiana produce sin límite; el del Vacío es la versión pesada.
Aparte van los Generadores Eléctricos, que dan energía, y su versión avanzada. Se distinguen a
propósito: en el fork original los dos se llamaban casi igual en chino y era imposible saber cuál
era cuál en la guía.

**Forja y conversión.** La Mesa de Forja de Obsidiana para las recetas de la rama, y un Conversor
de Netherita que saca lingotes directamente de roca.

**Equipo.** La armadura completa —Corona del Vacío, Coraza del Defensor, Grebas del Lamento y
Botas de la Bóveda— y el Pico Reforzado de Generadores, que recoge generadores de monstruos.

**Vuelo.** Núcleos de Vuelo Reforzados en tres niveles, con velocidad regulable, que dan vuelo
permanente mientras los lleves.

## Qué cambiamos

Este repositorio **no es un fork**: es el código original integrado en el ecosistema de
DrakesCraft.

**Una librería muerta, resuelta por el camino largo.** El addon dependía de
[InfinityLib](https://github.com/Mooy1/InfinityLib), un framework de addons compilado contra los
paquetes de Slimefun de upstream, que en nuestro core no existen. En vez de reescribir las diez
clases que la usan, portamos la librería entera: está en
[`DrakesCraft-Labs/InfinityLib-Drake`](https://github.com/DrakesCraft-Labs/InfinityLib-Drake).
Con eso se desbloquearon también SlimefunWarfare y MagicXpansion.

**PaperLib fuera.** Se usaba para una sola llamada, `getBlockState(b, false)`, que en Paper 1.21.11
es nativa (`b.getState(false)`). Una dependencia y una relocalización del shade menos.

**Al día con 1.21.11.** Paquetes de Slimefun al core Drake —incluido el árbol legacy de
`me.mrCookieSlime` y dough, que el core relocaliza a
`com.github.drakescraft_labs.slimefun4.libraries.dough`—, `paper-api` 1.21.11 y los renombres de
Bukkit: los `PotionEffectType` y los `Enchantment` cambiaron de nombre entre 1.16 y 1.21.

**Todo en español.** El catálogo venía entero en chino, incluidas las descripciones. Buena parte
del lore son versos clásicos chinos —hay al menos uno de Wang Han, de la dinastía Tang—; están
traducidos por su sentido, no palabra por palabra, porque literales no dicen nada.

## Instalación

Necesita Slimefun de DrakesCraft (`Slimefun4-Drake`). Se pone el jar en `plugins/` y listo. La
librería va dentro, no hace falta jar aparte.

## Crédito

El trabajo de fondo es de **lucasgithuber**. Nosotros solo lo hemos adaptado. Los detalles de
procedencia están en [UPSTREAM.md](UPSTREAM.md).

## ⚖️ Upstream Attribution & License / Licencia y Créditos

- **Original Project / Upstream**: Slimefun4 Community Addon.
- **Port & Maintenance**: DrakesCraft Labs team (Compatibility for Paper / Purpur 1.21.11).
- **License**: GPL-3.0 / MIT.
- **Source Code**: [GitHub Repository](https://github.com/DrakesCraft-Labs/ObsidianExpansion)
- **Support & Issues**: [GitHub Issues](https://github.com/DrakesCraft-Labs/ObsidianExpansion/issues) | [Discord](https://discord.gg/rR7FbfCt9Y)

*This project is an open-source derivative work maintained by DrakesCraft Labs under the terms of its original license. All original assets and concepts belong to their respective creators.*
