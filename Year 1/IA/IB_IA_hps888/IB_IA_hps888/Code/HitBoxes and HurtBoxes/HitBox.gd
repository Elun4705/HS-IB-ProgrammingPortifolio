extends Area2D

# This makes it possible so the number can be changed while debugging
# Export variable allow me to change the health in the editor instead for code

export var damage = 1 setget set_damage

# Allows me to change the damage not only in this node but globally too. To
# any node that is inheriting it
func set_damage(value):
	damage = value
