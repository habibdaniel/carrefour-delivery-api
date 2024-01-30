package com.carrefour.delivery.service;

import com.carrefour.delivery.domain.Delivery;
import com.carrefour.delivery.domain.Order;
import com.carrefour.delivery.domain.User;
import com.carrefour.delivery.model.OrderDTO;
import com.carrefour.delivery.repos.DeliveryRepository;
import com.carrefour.delivery.repos.OrderRepository;
import com.carrefour.delivery.repos.UserRepository;
import com.carrefour.delivery.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final DeliveryRepository deliveryRepository;
    private final UserRepository userRepository;

    public OrderService(final OrderRepository orderRepository,
            final DeliveryRepository deliveryRepository, final UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.deliveryRepository = deliveryRepository;
        this.userRepository = userRepository;
    }

    public List<OrderDTO> findAll() {
        final List<Order> orders = orderRepository.findAll(Sort.by("id"));
        return orders.stream()
                .map(order -> mapToDTO(order, new OrderDTO()))
                .toList();
    }

    public OrderDTO get(final Long id) {
        return orderRepository.findById(id)
                .map(order -> mapToDTO(order, new OrderDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final OrderDTO orderDTO) {
        final Order order = new Order();
        mapToEntity(orderDTO, order);
        return orderRepository.save(order).getId();
    }

    public void update(final Long id, final OrderDTO orderDTO) {
        final Order order = orderRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(orderDTO, order);
        orderRepository.save(order);
    }

    public void delete(final Long id) {
        orderRepository.deleteById(id);
    }

    private OrderDTO mapToDTO(final Order order, final OrderDTO orderDTO) {
        orderDTO.setId(order.getId());
        orderDTO.setReference(order.getReference());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setIddelivery(order.getIddelivery() == null ? null : order.getIddelivery().getId());
        orderDTO.setUserid(order.getUserid() == null ? null : order.getUserid().getId());
        return orderDTO;
    }

    private Order mapToEntity(final OrderDTO orderDTO, final Order order) {
        order.setReference(orderDTO.getReference());
        order.setStatus(orderDTO.getStatus());
        final Delivery iddelivery = orderDTO.getIddelivery() == null ? null : deliveryRepository.findById(orderDTO.getIddelivery())
                .orElseThrow(() -> new NotFoundException("iddelivery not found"));
        order.setIddelivery(iddelivery);
        final User userid = orderDTO.getUserid() == null ? null : userRepository.findById(orderDTO.getUserid())
                .orElseThrow(() -> new NotFoundException("userid not found"));
        order.setUserid(userid);
        return order;
    }

    public boolean referenceExists(final String reference) {
        return orderRepository.existsByReferenceIgnoreCase(reference);
    }

}
