# New Cow Beef

`New Cow Beef` is a Minecraft Forge `1.18.2` mod written in Kotlin. It adds two custom cow variants, each with its own biome placement and custom beef drop.

## Current Content

- `new_cow_beef:gold_cow`
  - Configured to spawn in `Nether Wastes`
  - Uses the vanilla cow model and animations
  - Keeps fire resistance so it can survive lava
  - Drops `new_cow_beef:gold_beef`
- `new_cow_beef:blue_cow`
  - Configured to spawn in ocean biomes and normal river
  - Does not spawn in frozen river
  - Uses the vanilla cow model and animations
  - Drops `new_cow_beef:blue_beef`

## Items

- `new_cow_beef:gold_beef`
  - Food item
  - Nutrition: `5`
- `new_cow_beef:blue_beef`
  - Food item
  - Nutrition: `7`

## Development

Requirements:
- Java `17`
- Minecraft `1.18.2`
- Forge `40.3.12`

Build the mod:

```bash
./gradlew build
```

Run the dev client:

```bash
./gradlew runClient
```

## Test Commands

Use these commands in-game to verify registration and rendering:

```mcfunction
/summon new_cow_beef:gold_cow
/summon new_cow_beef:blue_cow
```

## Project Layout

- Main mod entrypoint: `src/main/kotlin/com/github/shafiquejamal/newcowbeef/NewCowBeefMod.kt`
- Entity code: `src/main/kotlin/com/github/shafiquejamal/newcowbeef/entity/`
- Client renderers: `src/main/kotlin/com/github/shafiquejamal/newcowbeef/client/`
- Item code: `src/main/kotlin/com/github/shafiquejamal/newcowbeef/item/`
- Mod metadata: `src/main/resources/META-INF/mods.toml`
- Assets: `src/main/resources/assets/new_cow_beef/`
- Data files: `src/main/resources/data/new_cow_beef/`

## Notes

- Mod ID: `new_cow_beef`
- Main class: `com.github.shafiquejamal.newcowbeef.NewCowBeefMod`
- Current version: `0.1.2`
- Cow textures currently reuse copied placeholder art.
