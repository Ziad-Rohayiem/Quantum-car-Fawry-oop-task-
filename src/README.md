# Car Factory — OOP Design Exercise (for FAWRY Internship)

## Problem Description

Design a car factory system that models a car with a swappable engine. The car supports four operations: **start**, **stop**, **accelerate** (+20 km/h), and **brake** (-20 km/h), with a speed range of 0 to 200 km/h.

Three engine types are available — **Gas**, **Electric**, and **Hybrid**. Each engine maintains its own internal speed and exposes two low-level operations: `increase()` and `decrease()` (±1 km/h). The Hybrid engine contains both a Gas and an Electric sub-engine, using Electric below 50 km/h and Gas at 50 km/h and above, never running both simultaneously.

A **CarFactory** is responsible for creating cars by engine type and for replacing the engine of an existing car.

---

## Design Assumptions

- **Speed is owned by the engine, not the car.** The car holds no speed field of its own. All speed queries delegate to `engine.getSpeed()`.

- **The car drives speed changes through the engine's 1 km/h steps.** `accelerate()` calls `engine.increase()` exactly 20 times; `brake()` calls `engine.decrease()` exactly 20 times.

- **Speed is floored at 0 and capped at 200.** Braking never produces a negative speed; accelerating beyond 200 km/h is ignored.

- **`stop()` decrements speed gradually to 0** by calling `engine.decrease()` in a loop before marking the engine as stopped. It does not cut speed instantly.

- **`start()` sets the engine to running state at speed 0.** It does not accelerate the car.

- **The car only ever rests at multiples of 20** (0, 20, 40 … 200). Intermediate integer speeds exist transiently during an operation but are never a stable state.

- **The HybridEngine owns the single source-of-truth speed field.** Its Gas and Electric sub-engines are pure actuators — they execute increase/decrease but do not own speed themselves.

- **The Hybrid threshold check happens on every individual `increase()`/`decrease()` call**, not once per `accelerate()`/`brake()` invocation. This allows the engine switch to occur mid-operation when crossing 50 km/h.

- **The engine switch in the Hybrid is instantaneous and seamless.** There is no ramp-up for the incoming engine and no ramp-down for the outgoing one — speed continues uninterrupted from the HybridEngine's field.

- **The CarFactory is the sole place where engines are instantiated.** No engine is constructed directly outside the factory.

- **Internal Gas and Electric engine implementations are assumed correct** and are not tested in isolation (per the assignment note).

- **No thread safety, fuel levels, battery levels, or persistence** are modelled — this is a purely behavioural simulation.

---

## Project Structure

```
Engine.java          # Engine interface
GasEngine.java       # Concrete gas engine
ElectricEngine.java  # Concrete electric engine
HybridEngine.java    # Hybrid engine — delegates to gas or electric based on speed
Car.java             # Car — composes an Engine, exposes the four operations
CarFactory.java      # Factory — creates cars and replaces engines
Main.java            # Demo — exercises all car types and the replacement scenario
```

---

## How to Run

```bash
javac *.java
java Main
```