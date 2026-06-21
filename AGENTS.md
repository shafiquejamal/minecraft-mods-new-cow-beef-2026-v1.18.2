# AGENTS.md

## Scope

- This repository is a Minecraft Forge `1.18.2` mod written in Kotlin.
- The mod name is `New Cow Beef`.
- The mod ID / resource namespace is `new_cow_beef`.
- The Java package currently used by the code is `com.github.shafiquejamal.newcowbeef`.

## Build And Verification

- Use Java `17` for Gradle and Minecraft tasks.
- Primary verification command:

```bash
./gradlew build
```

- Useful local run command:

```bash
./gradlew runClient
```

- Do not invent other repo scripts unless they are added to the project.

## Project Layout

- Main mod entrypoint: `src/main/kotlin/com/github/shafiquejamal/newcowbeef/NewCowBeefMod.kt`
- Entity code: `src/main/kotlin/com/github/shafiquejamal/newcowbeef/entity/`
- Item code: `src/main/kotlin/com/github/shafiquejamal/newcowbeef/item/`
- Client renderers: `src/main/kotlin/com/github/shafiquejamal/newcowbeef/client/`
- Mod metadata: `src/main/resources/META-INF/mods.toml`
- Asset namespace root: `src/main/resources/assets/new_cow_beef/`
- Data namespace root: `src/main/resources/data/new_cow_beef/`

## Current Mod Behavior

- Adds two custom cows:
  - `new_cow_beef:gold_cow`
  - `new_cow_beef:blue_cow`
- Gold cow spawns only in `Nether Wastes`.
- Blue cow spawns in ocean biomes and normal river, but not frozen river.
- Gold cow maintains fire resistance so it survives lava.
- Gold cow drops `new_cow_beef:gold_beef`.
- Blue cow drops `new_cow_beef:blue_beef`.

## Editing Rules

- Keep the mod ID as `new_cow_beef` unless the user explicitly asks to rename it.
- Keep resource paths, loot tables, language keys, and registered IDs aligned with the `new_cow_beef` namespace.
- Prefer small, direct Kotlin changes over adding unnecessary abstractions.
- Reuse vanilla models and copied placeholder textures unless the user asks for new art or custom geometry.
- When adding items, also add the corresponding language entry and item model.
- When adding entity drops, keep the loot table under `data/new_cow_beef/loot_tables/entities/`.
- When changing entity rendering, keep client-only code under `client/`.

## Instruction Feedback

- When a user instruction is clear enough to execute but is materially ambiguous, under-specified, or likely to cause the wrong implementation, provide brief feedback on how the instruction could be written more precisely.
- Give this feedback after completing the requested task unless the ambiguity blocks progress.
- Keep the feedback concise: explain the ambiguity and provide one improved example phrasing.
- Do not give instruction-writing feedback for minor wording issues that do not affect implementation.

## Notes

- This project uses Kotlin for Forge on Forge `40.3.12`.
- Generated or copied placeholder textures may be intentionally temporary; do not treat them as final art.
