package net.mcreator.mymc.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.level.LevelAccessor;

public class SteelIngotWanJiaWanChengShiYongWuPinShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Math.round(2 / 2); index0++) {
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 100));
		}
	}
}
