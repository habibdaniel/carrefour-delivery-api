package com.carrefour.delivery.service;

import com.carrefour.delivery.domain.Delivery;
import com.carrefour.delivery.model.DeliveryDTO;
import com.carrefour.delivery.repos.DeliveryRepository;
import com.carrefour.delivery.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(final DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<DeliveryDTO> findAll() {
        final List<Delivery> deliveries = deliveryRepository.findAll(Sort.by("id"));
        return deliveries.stream()
                .map(delivery -> mapToDTO(delivery, new DeliveryDTO()))
                .toList();
    }

    public DeliveryDTO get(final Long id) {
        return deliveryRepository.findById(id)
                .map(delivery -> mapToDTO(delivery, new DeliveryDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final DeliveryDTO deliveryDTO) {
        final Delivery delivery = new Delivery();
        mapToEntity(deliveryDTO, delivery);
        return deliveryRepository.save(delivery).getId();
    }

    public void update(final Long id, final DeliveryDTO deliveryDTO) {
        final Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(deliveryDTO, delivery);
        deliveryRepository.save(delivery);
    }

    public void delete(final Long id) {
        deliveryRepository.deleteById(id);
    }

    private DeliveryDTO mapToDTO(final Delivery delivery, final DeliveryDTO deliveryDTO) {
        deliveryDTO.setId(delivery.getId());
        deliveryDTO.setModeId(delivery.getModeId());
        deliveryDTO.setStartSlotTime(delivery.getStartSlotTime());
        deliveryDTO.setEndSlotTime(delivery.getEndSlotTime());
        deliveryDTO.setDeliveryDay(delivery.getDeliveryDay());
        return deliveryDTO;
    }

    private Delivery mapToEntity(final DeliveryDTO deliveryDTO, final Delivery delivery) {
        delivery.setModeId(deliveryDTO.getModeId());
        delivery.setStartSlotTime(deliveryDTO.getStartSlotTime());
        delivery.setEndSlotTime(deliveryDTO.getEndSlotTime());
        delivery.setDeliveryDay(deliveryDTO.getDeliveryDay());
        return delivery;
    }

}
